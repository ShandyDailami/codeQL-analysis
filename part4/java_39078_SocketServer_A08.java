import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.*;

public class java_39078_SocketServer_A08 {
    private static final int PORT = 4446;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setEnabledCertificates(new File("client.pem"));

            System.out.println("Waiting for client connection...");
            clientSocket = serverSocket.accept();
            System.out.println("Client Connected");

            SSLSocket sslSocket = (SSLSocket) clientSocket.createChannel(clientSocket.getChannel());
            sslSocket.setEnableMutual(true);

            // Setup SSL Context
            SSLContext sslContext = SSLContext.getInstance("TLSv1_2");
            sslContext.init(null, new TrustManager[]{new TrustAnyTrustManager()}, null);
            sslSocket.setSSLContext(sslContext);

            // Now, the SSLSocket can be used to send/receive messages
        } catch (SSLException e) {
            System.out.println("SSL Exception occurred: " + e.getMessage());
        } catch (SocketException e) {
            System.out.println("Socket Exception occurred: " + e.getMessage());
        }

        // Close the server and client sockets
        if (serverSocket != null)
            serverSocket.close();
        if (clientSocket != null)
            clientSocket.close();
    }
}