import java.io.*;
import java.net.*;

public class java_41694_SocketServer_A08 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create a server socket
            serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234...");

            while (true) {
                // Step 2: Accept a client connection
                socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Step 3: Handle the client connection
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                // Step 4: Read from the client
                String message = inputStream.readUTF();
                System.out.println("Received: " + message);

                // Step 5: Send a response
                String response = "Hello Client, you connected successfully!";
                outputStream.writeUTF(response);
                System.out.println("Sent: " + response);

                // Close the connections
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the server socket
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}