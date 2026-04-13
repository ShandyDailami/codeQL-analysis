import java.io.*;
import java.net.*;

public class java_02445_SocketServer_A07 {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;
    private static Socket socket;

    public static void main(String[] args) {
        System.out.println("Server started");

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

            // Accept a client socket
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Get input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Get the client's name
            String clientName = in.readUTF();
            System.out.println(clientName + " connected to the server");

            // Authenticate the client
            if(authenticateClient(clientName)){
                // Send a greeting message
                out.writeUTF("Hello " + clientName);
            }else{
                out.writeUTF("Authentication failed");
            }

            // Close the connections
            out.close();
            in.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateClient(String clientName) {
        // Here you can add the logic for authentication
        // You can use a predefined list of valid names and compare the input with them
        // For the sake of simplicity, we'll just check if the input is 'admin'
        return clientName.equals("admin");
    }
}