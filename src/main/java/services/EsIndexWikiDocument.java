package services;

import beans.WikiBean;
import org.elasticsearch.action.index.IndexResponse;
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


    public String indexDocument(WikiBean wikiBean) {

        String documentId = wikiBean.getDocumentId();
        if (documentId.equals("-1")) {
            documentId = EncryptionUtils.getCryptoHash(wikiBean.getTitle()+wikiBean.getUserId());
        }

        try {
            IndexResponse response = esClient.prepareIndex(
                    "wiki",
                    "wiki",
                    documentId
                    )
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("user_id", wikiBean.getUserId())
                            .field("title", wikiBean.getTitle())
                            .field("content", wikiBean.getContent())
                            .field("team_name", wikiBean.getTeamName())
                            .field("visible_to", wikiBean.getVisibleTo())
                            .field("html_content", wikiBean.getHtmlContent())
                            .field("description", wikiBean.getDescription())
                            .endObject()
                    )
                    .get();
            return documentId;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        // -1 denotes document was not saved
        return "-1";
    }

}
