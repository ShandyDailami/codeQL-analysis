import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_13561_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;
        BufferedReader reader = null;

        try {
            // Create a server socket and bind it to port 12345
            serverSocket = (SSLServerSocket) new SSLServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            System.out.println("Waiting for client authentication...");

            // Accept a client connection
            clientSocket = (SSLSocket) serverSocket.accept();

            System.out.println("Client authenticated");

            // Create a reader
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Read from the client
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Client says: " + line);
           
                // Write a response
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                writer.println("Server says: " + line);
            }
        } finally {
            // Close the connections
            if (reader != null) {
                reader.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}