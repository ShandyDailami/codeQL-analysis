import java.io.*;
import java.net.*;

public class java_19086_SocketServer_A07 {

    public static void main(String[] args) {

        // Step 1: Create a socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6000); // Set your port
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Accept a connection
        System.out.println("Server is listening on port 6000");
        Socket socket = null;
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 3: Create input and output streams
        try (OutputStream os = socket.getOutputStream();
             InputStream is = socket.getInputStream()) {

            // Step 4: Send a welcome message
            byte[] welcomeMsg = "Welcome to the server!".getBytes();
            os.write(welcomeMsg);

            // Step 5: Receive a message and echo it back
            byte[] receiveMsg = new byte[1024];
            int bytesRead = is.read(receiveMsg);
            if (bytesRead < 0) {
                System.out.println("Client disconnected!");
                return;
            }

            String message = new String(receiveMsg, 0, bytesRead);
            System.out.println("Received message: " + message);

            // Step 6: Echo the message back
            byte[] sendMsg = message.getBytes();
            os.write(sendMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}