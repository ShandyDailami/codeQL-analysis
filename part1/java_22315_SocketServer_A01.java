import java.io.*;
import java.net.*;

public class java_22315_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create a server socket
            serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            // Step 2: Wait for a client to connect
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Send a response to the client
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Hello client, you are now connected to the secure server!");
            System.out.println("Message sent to the client");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Close the socket
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}