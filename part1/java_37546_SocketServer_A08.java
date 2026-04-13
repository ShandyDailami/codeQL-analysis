import java.io.*;
import java.net.*;

public class java_37546_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Read the message from the client
                String message = input.readUTF();

                // Process the message (for example, check the integrity of the message)
                if (processMessage(message)) {
                    output.writeUTF("Message processed successfully");
                } else {
                    output.writeUTF("Error processing message: integrity failure");
                }

                // Close the connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean processMessage(String message) {
        // Here, we are just checking if the message is null or empty
        // in a real scenario, you would process the message and check its integrity
        return message != null && !message.isEmpty();
    }
}