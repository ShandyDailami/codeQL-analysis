import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_31149_SocketServer_A03 {

    private static final Logger LOGGER = Logger.getLogger(SecureServer.class.getName());

    private static final int PORT = 8443;
    private static final String CLIENT_IDENTIFIER = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1284.346 Safari/537.1";

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setSoTimeout(60000);
            while (true) {
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                clientSocket.setSoTimeout(60000);
                System.out.println("Connection accepted from " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Exception caught when trying to listen on port " + PORT, ex);
        }
    }

    private static void handleClient(SSLSocket clientSocket) {
        try {
            OutputStream outToClient = clientSocket.getOutputStream();
            String response = "Hello from secure server!";
            outToClient.println(response);
            outToClient.close();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Exception caught when trying to write to " + clientSocket.getRemoteSocketAddress(), ex);
        }
    }
}