package services;

import beans.WikiBean;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Client;
import utils.EncryptionUtils;

import java.util.Calendar;
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
        String field = "last_edited_by";
        Boolean isNewDoc = false;
        if (documentId.equals("-1")) {
            documentId = EncryptionUtils.getCryptoHash(wikiBean.getTitle()
                                                        +wikiBean.getUserId()
                                                        + Calendar.getInstance().get(Calendar.MILLISECOND));
            field = "owner_name";
            isNewDoc = true;
        }

        try {
            if (isNewDoc) {
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
                                .field(field, wikiBean.getUserName())
                                .endObject()
                        )
                        .get();
            } else {

                UpdateRequest updateRequest = new UpdateRequest();
                updateRequest.index("wiki");
                updateRequest.type("wiki");
                updateRequest.id(documentId);
                updateRequest.doc(jsonBuilder()
                        .startObject()
                        .field("user_id", wikiBean.getUserId())
                        .field("title", wikiBean.getTitle())
                        .field("content", wikiBean.getContent())
                        .field("team_name", wikiBean.getTeamName())
                        .field("visible_to", wikiBean.getVisibleTo())
                        .field("html_content", wikiBean.getHtmlContent())
                        .field("description", wikiBean.getDescription())
                        .field(field, wikiBean.getUserName())
                        .endObject());
                esClient.update(updateRequest).get();
            }

            return documentId;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        // -1 denotes document was not saved
        return "-1";
    }

}
