import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_30832_SocketServer_A08 {
    private static SSLServerSocket serverSocket;
    private static Socket clientSocket;
    private static SSLSocket sslSocket;
    private static BufferedReader inFromClient;
    private static PrintWriter outToClient;

    public static void main(String[] args) {
        // Generate SSLServerSocket and SSLSocket
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(5000);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, null, null);
            serverSocket.setSSLContext(sslContext);
            serverSocket.setNeedClientAuth(true);
            clientSocket = serverSocket.accept();
            sslSocket = (SSLSocket) clientSocket.getSocket();

            // Set up stream for client
            inFromClient = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            outToClient = new PrintWriter(sslSocket.getOutputStream(), true);

            // Send authentication request
            outToClient.println("Hello Client, please enter your password:");
            outToClient.flush();

            // Read server's challenge
            String challenge = inFromClient.readLine();
            System.out.println("Server's challenge: " + challenge);

            // Get client's password
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String clientPassword = consoleReader.readLine();

            // Verify client's password
            if (challenge.equals(clientPassword)) {
                outToClient.println("Authentication successful!");
            } else {
                outToClient.println("Authentication failed!");
              }

            outToClient.close();
            inFromClient.close();
            sslSocket.close();
            clientSocket.close();
            serverSocket.close();
        } catch (SSLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}