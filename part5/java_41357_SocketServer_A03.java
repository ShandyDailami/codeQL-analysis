import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_41357_SocketServer_A03 {
    private static SSLServerSocket serverSocket;
    private static Socket clientSocket;
    private static BufferedReader inFromClient;
    private static PrintWriter outToClient;

    public static void main(String[] args) {
        System.out.println("Server started");

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

                SSLSession clientSession = clientSocket.getSession();
                System.out.println("Client certificates: " + clientSession.getPeerCertificates());

                String request;
                while ((request = inFromClient.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Here you can implement your logic to prevent Injection.
                    // For example, you can verify if the request is safe to execute,
                    // or if it contains valid input that you trust.

                    outToClient.println("Hello client, your message was: " + request);
                    outToClient.flush();
                }
                clientSocket.close();
            }
        } catch (SSLException e) {
            e.printStackTrace();
        }
    }
}