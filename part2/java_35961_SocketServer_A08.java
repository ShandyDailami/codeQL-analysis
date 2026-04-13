import java.net.*;
import java.io.*;

public class java_35961_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                // Accept a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected");

                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Read from the client
                String clientMessage = in.readLine();
                System.out.println("Received: " + clientMessage);

                // Send a response
                String serverMessage = "Hello, Client!";
                out.writeBytes(serverMessage + "\n");

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}