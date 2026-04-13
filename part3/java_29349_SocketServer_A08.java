import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_29349_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    private static final int SERVER_PORT = 8080;
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) {
        // create SSL server socket factory
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStorePassword(KEYSTORE_PASSWORD);
        sslServerSocketFactory.setKeyStoreLocation(KEYSTORE_LOCATION);
        sslServerSocketFactory.setTrustStorePassword(TRUSTSTORE_PASSWORD);
        sslServerSocketFactory.setTrustStoreLocation(TRUSTSTORE_LOCATION);

        try (ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT)) {
            logger.info("Server started on port: " + SERVER_PORT);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                logger.info("Client connected");

                // start handling data
                handleData(clientSocket);
            }
        } catch (IOException e) {
            logger.severe("Failed to start the server: " + e.getMessage());
        }
    }

    private static void handleData(SSLSocket clientSocket) {
        try (InputStream in = clientSocket.getInputStream();
             OutputStream out = clientSocket.getOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                // perform integrity check here
                // for simplicity, we'll just check if the length of data is correct
                if (bytesRead != buffer.length) {
                    logger.severe("Integrity check failure. Expected data length: " + buffer.length);
                    // if the data length is incorrect, close the connection
                    clientSocket.close();
                    return;
                }

                // if everything is correct, write "OK" to the output stream
                out.write(("OK\n").getBytes());
            }
        } catch (IOException e) {
            logger.severe("Failed to handle data: " + e.getMessage());
        }
    }
}