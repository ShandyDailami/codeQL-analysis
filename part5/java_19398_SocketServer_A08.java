import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_19398_SocketServer_A08 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        // Create a server socket using SSL
        SSLServerSocket serverSocket = (SSLServerSocket) SSLServerSocketFactory.createServerSocket(8080, 50000, true, InetAddress.getByName("localhost"));
        serverSocket.setNeedClientAuth(true);
        serverSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

        // Accept client connection
        Socket clientSocket = serverSocket.accept();

        // Here you can add the code to handle the client connection

        // Close the server socket
        serverSocket.close();
    }
}