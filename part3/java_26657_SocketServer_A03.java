import java.io.*;
import java.net.*;

public class java_26657_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(3333); // Listening port
            System.out.println("Server started at port 3333");

            while (true) {
                socket = server.accept(); // Accepting connection
                System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());

                // Creating new streams for communication
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Sending welcome message
                out.writeUTF("Welcome to the server. You're connected to port 3333");

                // Handling client messages
                String message = in.readUTF();
                System.out.println("Client says: " + message);

                // Sending back a response
                out.writeUTF("Hello client, you've connected successfully to port 3333");

                socket.close(); // Close the connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close(); // Close the server
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}