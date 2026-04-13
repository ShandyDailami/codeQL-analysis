import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_05477_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Create a server socket that listens on port 12345
            serverSocket = new ServerSocket(12345);

            // Create an SSLServerSocket that listens on port 12345 using the specified key and truststore
            sslServerSocket = (SSLServerSocket) serverSocket.accept();

            // Create a buffered reader for the SSL socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslServerSocket.getInputStream()));

            // Read a line of the message from the client
            String message = reader.readLine();

            // Print the received message
            System.out.println("Received: " + message);

            // Send a response back to the client
            PrintWriter writer = new PrintWriter(sslServerSocket.getOutputStream(), true);
            writer.println("Server received your message!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocket != null) sslServerSocket.close();
            if (serverSocket != null) serverSocket.close();
        }
    }
}