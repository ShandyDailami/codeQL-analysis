import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_27368_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setEnabledCertificates("server.crt");

            clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Send a greeting message to the client
            out.println("Hello, Client!");

            // Close the connection
            clientSocket.close();
        } finally {
            in.close();
            out.close();
            serverSocket.close();
        }
    }
}