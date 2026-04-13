import java.net.*;
import java.io.*;

public class java_23013_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            // Step 1: Setup the server socket
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            // Step 2: Accept a client socket
            Socket clientSocket = serverSocket.accept();
            System.out.println("A client has connected!");

            // Step 3: Setup input and output streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Step 4: Handle the client
            while (true) {
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Step 5: Send a response
                String response = "Hello, client!";
                out.writeUTF(response);
                out.flush();
            }

            // Close the connections
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}