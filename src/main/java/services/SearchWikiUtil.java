package services;


import com.google.gson.Gson;
import databases.ESConnectionManager;
import databases.ESUtils;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.SearchHit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sourabh.su on 23/01/17.
 */
public class SearchWikiUtil {

    private Client esClient;
    private static Integer maxNumberOfAttempts = 5;


    public String searchWiki(String query, String teamId){
        MultiSearchResponse response = null;
        Integer numberofAttempts = 0;

        while (numberofAttempts < maxNumberOfAttempts) {
            this.esClient = new ESConnectionManager().getEsClient();
            if (this.esClient!=null) {
                ESUtils esUtils = new ESUtils(esClient);
                response = esUtils.searchByTitle(query, teamId);
                break;
            }
            numberofAttempts++;
        }

        String result = "";
        if (response!=null) {
            MultiSearchResponse.Item[] items = response.getResponses();
            Gson gson = new Gson();

            List<Map> mylist = new ArrayList<Map>();
            for (MultiSearchResponse.Item item : items) {
                if (item != null) {
                    for (SearchHit hit : item.getResponse().getHits()) {
                        Map map = hit.getSource();
                        mylist.add(map);
                    }
                }
            }
            result = gson.toJson(mylist);
        }

        return result;
    }

}
