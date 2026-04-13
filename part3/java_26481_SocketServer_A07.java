import java.io.*;
import java.net.*;
import javax.servlet.*;
import org.apache.tomcat.util.netjspi.*;

public class java_26481_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.setExecutor(null);
        server.setProtocol("HTTP/1.1");
        server.setSuspended(false);
        server.setCachedResponseAware(true);
        server.setRequestQueue(new DefaultRequestQueue(server.getExecutor()));

        ServerConnector connector = new ServerConnector(server, new Http11ConnectionFactory());
        connector.setScheme("https");
        connector.setSecure(true);

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new File[]{new File("server.key")}, null);
        connector.setSslContext(sslContext);

        server.addConnector(connector);

        server.start();

        server.getServer().awaitTermination();
    }

}