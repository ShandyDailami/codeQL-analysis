import java.io.*;
import java.net.*;

public class java_30389_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444); // listening port
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected");

                // Create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read message from client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send response back to client
                out.writeUTF("Server received your message: " + message);
                out.flush();

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}