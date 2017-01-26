package databases;

/**
 * Created by sourabh.su on 21/01/17.
 */
import errorHandling.CustomException;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;

public class ESConnection {

    public static Client getConnection (String elasticIp, int elasticPort, String clusterName) throws CustomException{
        Client client = null;
        try {
            Settings settings = Settings.settingsBuilder().put("cluster.name", clusterName).build();
            client = TransportClient.builder()
                    .settings(settings)
                    .build()
                    .addTransportAddress( new InetSocketTransportAddress(InetAddress.getByName(elasticIp), elasticPort));
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage(), ex);
        }
        return client;
    }
}
