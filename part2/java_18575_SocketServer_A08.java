import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_18575_SocketServer_A08 {
    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create a SSLServerSocket for SSL port
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080, null, null, SSLServerSocket.getDefaultCipherSuite());
            System.out.println("Waiting for client on port 8080");

            // Wait for a client to connect
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Send a greeting to the client
            out.println("Hello Client, Welcome to Secure Server!");

            // Receive a line of text from the client
            String message = in.readLine();
            System.out.println("Server received: " + message);

            // Close the connection
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (clientSocket != null) try { clientSocket.close(); } catch (IOException e) { e.printStackTrace(); }
            if (serverSocket != null) try { serverSocket.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
}