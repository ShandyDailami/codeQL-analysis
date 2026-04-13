import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.util.Scanner;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.security.auth.login.LoginException;

public class java_14291_SocketServer_A07 {

    public static void main(String[] args) throws LoginException, CertificateException, IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        // Create a SSL Server socket
        serverSocket = (SSLServerSocket) new SSLServerSocket(4444, null, null, null);
        System.out.println("Waiting for client on port: " + serverSocket.getLocalPort());

        // Accept client socket
        clientSocket = (SSLSocket) serverSocket.accept();
        clientSocket.setNeedClientAuth(true);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        Scanner in = new Scanner(clientSocket.getInputStream());

        // Receive request from client
        String request = in.nextLine();
        System.out.println("Received: " + request);

        // Send response
        out.println("Hello, Client");

        // Close connection
        clientSocket.close();
    }
}