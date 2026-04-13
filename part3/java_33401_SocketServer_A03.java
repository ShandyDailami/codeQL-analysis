import java.io.*;
import java.net.*;

public class java_33401_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Waiting for client connection...");
            
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read and write messages
            String messageFromClient;
            while ((messageFromClient = in.readLine()) != null) {
                System.out.println("Received: " + messageFromClient);
                out.println("Server says: " + messageFromClient);
            }

            // Close connection
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}