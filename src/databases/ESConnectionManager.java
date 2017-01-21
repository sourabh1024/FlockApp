package databases;

import org.elasticsearch.client.Client;
import utils.SysProperties;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class ESConnectionManager {

    private Client esClient;

    public ESConnectionManager() {
        this.esClient = null;
    }

    public Client getEsClient() {
        if (this.esClient == null) {
            try {
                this.esClient = ESConnection.getConnection(
                        "127.0.0.1",
                        9300,
                        "elasticsearch"
                );
            } catch (Exception ex) {
                System.out.println("Exception while creating Elastic Search Client");
                System.out.println(ex);
            }
        }
        return esClient;
    }

    public void tryEsConnection() {
        try {
            if (this.esClient != null) {
                esClient.close();
                this.esClient = null;
            }
        } catch (Exception ex) {
            System.out.println("Exception while closing ES connection");
        }
    }

}
