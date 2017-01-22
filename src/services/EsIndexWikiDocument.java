package services;

import beans.WikiDocument;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchResponse;
import static org.elasticsearch.common.xcontent.XContentFactory.*;
import org.elasticsearch.client.Client;
import utils.EncryptionUtils;

import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class EsIndexWikiDocument {

    private Client esClient;

    private EsIndexWikiDocument() {

    }

    public EsIndexWikiDocument(Client esClient) {
        this.esClient = esClient;
    }

    public String EsQuery(WikiDocument wikiDocument){
        String query = "PUT /wiki/wiki/"+1001+"\n" +
                "{\n" +
                "    \"user_id\":\""+wikiDocument.getUserId()+"\",\n" +
                "    \"title\":\""+wikiDocument.getTitle()+"\",\n" +
                "    \"content\":\""+wikiDocument.getContent()+"\",\n" +
                "    \"team_name\":\""+wikiDocument.getTeamName()+"\"\n" +
                "}";
        return query;
    }

    public IndexResponse indexDocument(WikiDocument wikiDocument) {
        try {
            IndexResponse response = esClient.prepareIndex("wiki", "wiki", EncryptionUtils.getCryptoHash(wikiDocument.getTitle()+wikiDocument.getUserId()))
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("user_id", wikiDocument.getUserId())
                            .field("title", wikiDocument.getTitle())
                            .field("content", wikiDocument.getContent())
                            .field("team_name", wikiDocument.getTeamName())
                            .endObject()
                    )
                    .get();
            return response;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

}
