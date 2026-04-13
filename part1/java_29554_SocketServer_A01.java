import java.io.*;
import java.net.*;

public class java_29554_SocketServer_A01 {
    private static final int port = 8080;

    public static void main(String[] args) {
        // Create server socket
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port + "...");

            // Accept client connection
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create input and output streams
                try (DataInputStream in = new DataInputStream(socket.getInputStream());
                     DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                    // Read message from client
                    String message = in.readUTF();
                    System.out.println("Received: " + message);

                    // Check if message is "exit"
                    if (message.equals("exit")) {
                        System.out.println("Client disconnected");
                        break;
                    }

                    // Check for broken access control
                    if (message.contains("broken access control")) {
                        System.out.println("Broken access control detected");
                        // Replace the message with a predefined one
                        message = "Access denied";
                    }

                    // Send response to client
                    out.writeUTF(message);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}