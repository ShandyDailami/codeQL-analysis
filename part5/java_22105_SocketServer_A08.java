import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22105_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            // Create custom SSLContext using custom certificates
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/client.jks"), "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, null);

            serverSocket.setSSLEngine(sslContext.getSSLEngine());

            System.out.println("Server started at port 8080");

            while (true) {
                clientSocket = serverSocket.accept();

                System.out.println("New client connected");

                // Create new SSLSocket using custom SSLContext
                SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
                clientSocket = (SSLSocket) sslSocketFactory.createSocket(clientSocket, "localhost", 8080);

                // Here is where you'd handle the clientSocket and its input/output streams
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            clientSocket.close();
            serverSocket.close();
        }
    }
}