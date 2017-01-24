package databases;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;

/**
 * Created by sourabh.su on 23/01/17.
 */
public class ESUtils {

    private Client esClient;

    public ESUtils() {

    }

    public ESUtils(Client esClient) {
        this.esClient = esClient;
    }

    public String getESSearchQuery(String query, String teamId) {
        String esQuery = "{\"bool\": {\n" +
                "         \"must\": {\n" +
                "            \"multi_match\": {\n" +
                "               \"query\": \""+query+"\",\n" +
                "               \"fields\": [\n" +
                "                  \"title^3\",\n" +
                "                  \"content\"\n" +
                "               ]\n" +
                " , \"type\":\"phrase_prefix\"\n"+
                "            }\n" +
                "         },\n" +
                "         \"filter\": {\n" +
                "            \"bool\": {\n" +
                "               \"should\": [\n" +
                "                  {\n" +
                "                     \"term\": {\n" +
                "                        \"team_name\": \""+teamId+"\"\n" +
                "                     }\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"term\": {\n" +
                "                        \"visible_to\": \"all\"\n" +
                "                     }\n" +
                "                  }\n" +
                "               ]\n" +
                "            }\n" +
                "         }\n" +
                "      }}" ;
        return esQuery;
    }

    public MultiSearchResponse searchByTitle(String query, String teamId) {
        //TODO
        SearchRequestBuilder searchRequestBuilder = esClient.prepareSearch().setSize(50).setQuery(this.getESSearchQuery(query, teamId)).setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
        MultiSearchResponse multiSearchResponse = esClient.prepareMultiSearch().add(searchRequestBuilder).execute().actionGet();
        return multiSearchResponse;
    }

    public GetResponse getDocumentById(String documentId) {
        GetResponse response = esClient.prepareGet("wiki", "wiki", documentId)
                .execute()
                .actionGet();
        return response;
    }

}
