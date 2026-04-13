import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class java_02192_SocketServer_A01 {

    private static final int PORT = 8080;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        // Configure SSL
        TrustManager[] trustAllCerts = new TrustManager[] { new TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        } };
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());

        // Create non-blocking server socket channel
        SocketChannel ssc = SocketChannel.open();
        ssc.bind(PORT);
        ssc.configureBlocking(false);
        ssc.setOption(StandardSocketOptions.SO_REUSEADDR, true);
        ssc.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
        ssc.setOption(StandardSocketOptions.SO_SSL_REUSE_CONNECT, true);
        ssc.setOption(StandardSocketOptions.SO_SSL_SERVER_ONLY, true);
        ssc.setOption(StandardSocketOptions.SO_OPTIONS, true);
        ssc.setOption(StandardSocketOptions.SO_RCVBUF, 8*1024);
        ssc.setOption(StandardSocketOptions.SO_SNDBUF, 8*1024);
        ssc.setOption(StandardSocketOptions.SO_LINGER, 0);
        ssc.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
        ssc.setOption(StandardSocketOptions.SO_REUSEADDR, true);

        // SSL bind
        ssc.bind(sc.getServerSocketChannel(), HOST, PORT);

        // Accept client connections
        while (true) {
            SocketChannel sc = ssc.accept();
            sc.configureBlocking(false);

            // Read from client
            ByteBuffer buf = ByteBuffer.allocate(1024);
            sc.read(buf);
            String message = new String(buf.array(), "UTF-8");
            System.out.println("Received: " + message);

            // Write to client
            String response = "Hello, client!";
            buf.clear();
            buf.put(response.getBytes());
            sc.write(buf);
            sc.close();
        }
    }
}