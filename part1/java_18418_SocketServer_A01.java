import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.ServerSocketChannel;

public class java_18418_SocketServer_A01 {

    private static final Logger logger = Logger.getLogger(SecureServer.class.getName());

    public static void main(String[] args) throws IOException {
        SSLServerSocketChannel sslServerChannel = null;
        ServerSocketChannel serverChannel = null;
        SSLEngine sslEngine = null;
        SSLContext sslContext = SSLContext.getInstance("TLS");

        try {
            sslContext.init(null, new String[] { "SSL_SERVER_KEY.pem", "SSL_SERVER_CERT.pem" }, null);
            sslServerChannel = (SSLServerSocketChannel) sslContext.getServerSocketChannel();
            sslServerChannel.bind(PORT);

            serverChannel = sslServerChannel.accept();
            sslEngine = sslServerChannel.createSSLEngine(serverChannel);
            sslEngine.setUseClientMode(true);
            sslEngine.startHandshake();
            serverChannel.configureBlocking(false);

            ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            pool.execute(new SocketHandler(serverChannel, sslEngine));

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error in accepting client connection", ex);
        } finally {
            sslServerChannel.close();
            serverChannel.close();
            sslEngine.close();
            pool.shutdown();
        }
    }
}