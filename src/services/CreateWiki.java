package services;

import beans.WikiDocument;
import databases.ESConnectionManager;
import org.elasticsearch.client.Client;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class CreateWiki {

    private WikiDocument wikiDocument;
    private Client esClient;
    private ESConnectionManager esConnectionManager;
    private static final Integer maxNumberOfAttempts = 5;

    private CreateWiki() {
    }

    public CreateWiki (WikiDocument wikiDocument) {
        this.wikiDocument = wikiDocument;
    }

    public boolean addDocumentToDataBase() {
        Integer numberofAttempts = 0;
        while (numberofAttempts < maxNumberOfAttempts) {
            this.esClient = new ESConnectionManager().getEsClient();
            if (this.esClient!=null) {

                return true;
            }
            numberofAttempts++;
        }
        return false;
    }
}
