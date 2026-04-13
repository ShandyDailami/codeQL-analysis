import java.net.*;
import java.io.*;

public class java_33257_SocketServer_A08 {

    private static String CLIENT_MESSAGE = "Hello Client!";

    public static void main(String[] args) throws Exception {

        // Create server socket
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on port: 1234");

        while (true) {
            // Wait for client to connect
            System.out.println("Waiting for client on port 1234");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String clientMessage = input.readUTF();
            System.out.println("Client message: " + clientMessage);

            // Check for integrity failure
            if (clientMessage.equals(CLIENT_MESSAGE)) {
                System.out.println("Integrity failure detected");
            }

            // Send back to client
            output.writeUTF(CLIENT_MESSAGE);
            output.flush();

            // Close the streams
            input.close();
            output.close();

            // Close the socket
            socket.close();

        }
    }
}