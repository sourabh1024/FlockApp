package services;

import beans.WikiBean;
import beans.WikiDocument;
import databases.ESConnectionManager;
import databases.MySqlConnectionManager;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class CreateWiki {

    private Client esClient;
    private EsIndexWikiDocument esIndexWikiDocument;
    private static CreateWiki createWiki;
    private MySqlConnectionManager mySqlConnectionManager;

    private static final Integer maxNumberOfAttempts = 5;

    public String addDocumentToDataBase(WikiBean wikiBean) {
        Integer numberofAttempts = 0;
        while (numberofAttempts < maxNumberOfAttempts) {
            this.esClient = new ESConnectionManager().getEsClient();
            if (this.esClient!=null) {
                esIndexWikiDocument = new EsIndexWikiDocument(esClient);
                String indexResponse = esIndexWikiDocument.indexDocument(wikiBean);
                if (indexResponse != null) {
                    //TODO : Check if the document has been indexed
                    return indexResponse;
                }
            }
            numberofAttempts++;
        }
        return "-1";
    }

    public Map getUserDetailsFromSql(String userId) {
        HashMap<String, String> userDetails = new LinkedHashMap<String, String>();
        try {
            this.mySqlConnectionManager = new MySqlConnectionManager();
            Connection connection = mySqlConnectionManager.getSqlConnection();
            String query = "SELECT * FROM user_info WHERE userid = '" + userId +"'";
            System.out.println("Query :"+ query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                userDetails.put("teamId", resultSet.getString("teamid"));
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return userDetails;
    }

    public static CreateWiki getInstance() {
        if (createWiki == null) {
            createWiki = new CreateWiki();
        }
        return createWiki;
    }
}
