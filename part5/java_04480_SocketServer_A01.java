import java.io.*;
import java.net.*;

public class java_04480_SocketServer_A01 {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;

        try {
            server = new ServerSocket(4444); // Create a server socket on port 4444
            System.out.println("Waiting for a client...");

            // Accept a new client connection
            socket = server.accept();
            System.out.println("Client connected!");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Handle data received from client
            while (true) {
                String message = dis.readUTF(); // Receive a message from the client
                System.out.println("Received: " + message);

                // Send a response back to the client
                dos.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "!");
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}