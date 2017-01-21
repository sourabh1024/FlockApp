package services;

import beans.WikiDocument;
import databases.ESConnectionManager;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class CreateWiki {

    private Client esClient;
    private EsIndexWikiDocument esIndexWikiDocument;
    private static CreateWiki createWiki;

    private static final Integer maxNumberOfAttempts = 5;

    public  CreateWiki() {
    }

    public boolean addDocumentToDataBase(WikiDocument wikiDocument) {
        Integer numberofAttempts = 0;
        while (numberofAttempts < maxNumberOfAttempts) {
            this.esClient = new ESConnectionManager().getEsClient();
            if (this.esClient!=null) {
                esIndexWikiDocument = new EsIndexWikiDocument(esClient);
                IndexResponse indexResponse = esIndexWikiDocument.indexDocument(wikiDocument);
                if (indexResponse != null) {
                    //TODO : Check if the document has been indexed
                    return true;
                }
            }
            numberofAttempts++;
        }
        return false;
    }

    public static CreateWiki getInstance() {
        if (createWiki == null) {
            createWiki = new CreateWiki();
        }
        return createWiki;
    }
}
