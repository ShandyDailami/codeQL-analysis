import java.io.*;
import java.net.*;

public class java_12684_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Setup server socket
            serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port: 5000");

            // Step 2: Wait for a client to connect
            socket = serverSocket.accept();
            System.out.println("A client is connected!");

            // Step 3: Communicate with the client
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String clientMessage;

            while ((clientMessage = inputStream.readUTF()) != null) {
                System.out.println("Received: " + clientMessage);

                // Step 4: Respond with a message to the client
                String serverMessage = "Server received your message: " + clientMessage;
                outputStream.writeUTF(serverMessage);
                System.out.println("Sent: " + serverMessage);
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}