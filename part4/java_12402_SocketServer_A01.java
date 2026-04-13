import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;

public class java_12402_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8080;

        // Load the SSL certificate and private key
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream in = new FileInputStream("path_to_your_keystore.jks")) {
            keyStore.load(in, "password".toCharArray());
        } catch (IOException | KeyStoreException e) {
            e.printStackTrace();
            System.exit(1);
        }

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword("password");

        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port)) {
            System.out.println("Server started");

            while (true) {
                // Blocking call to accept a new connection
                InetSocketAddress inetSocketAddress = (InetSocketAddress) sslServerSocket.accept();
                System.out.println("Client connected : " + inetSocketAddress.getPort());

                // Create a new thread for handling the client
                HandlerThread handlerThread = new HandlerThread("Thread-SocketServer-");
                handlerThread.start();
                Handler handler = new Handler(handlerThread) {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        // Handle message from client
                    }
                };

                // Send the message to the client
                MessageToMessageEncoder encoder = new MessageToMessageEncoder(msg, Message.class);
                sslServerSocket.setNeedClientAuthentication(true);
            }
        } catch (IOException | JSSEException e) {
            e.printStackTrace();
        }
    }
}