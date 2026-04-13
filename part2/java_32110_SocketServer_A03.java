import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_32110_SocketServer_A03 {

    public static void main(String[] args) throws CertificateException, IOException {
        // Load a truststore from an external file
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("truststore.jks"), "truststorepassword".toCharArray());

        // Load a keystore from an external file
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("keystore.jks"), "keystorepassword".toCharArray());

        // Create a SSLContext using the keyStore and trustStore
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, null, trustStore);

        // Bind the SSLContext to the server port
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8443));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is waiting for client connection...");

        while (true) {
            SocketChannel clientChannel = serverSocketChannel.accept();
            if (clientChannel != null) {
                System.out.println("Client connected!");

                // Set the SSLContext for the channel
                SSLChannel sslChannel = (SSLChannel) clientChannel;
                sslChannel.setEnable(true);
                sslChannel.setSSLContext(sslContext);

                // Start a new thread to handle the client communication
                new ClientHandler(sslChannel).start();
            }
        }
    }

    static class ClientHandler extends Thread {
        SSLChannel channel;

        ClientHandler(SSLChannel channel) {
            this.channel = channel;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = channel.read(buffer)) != -1) {
                System.out.println("Received: " + new String(buffer, 0, bytesRead));

                // Echo the received data back to the client
                channel.write(buffer, bytesRead);
            }

            // Close the channel when the client disconnects
            channel.close();
        }
    }
}