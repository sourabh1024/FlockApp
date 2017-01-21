package services;

import beans.WikiDocument;
import org.elasticsearch.client.Client;

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
        String query = "";
        return query;
    }

}
