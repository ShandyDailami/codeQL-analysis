import java.io.*;
import java.net.*;

public class java_29155_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 1234;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create output stream for client
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Create input stream for client
                DataInputStream input = new DataInputStream(socket.getInputStream());

                // Read message from client
                String message = input.readUTF();
                System.out.println("Received: " + message);

                // Send back a response
                output.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
                System.out.println("Sent: " + "Thank you for connecting to " + socket.getRemoteSocketAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}