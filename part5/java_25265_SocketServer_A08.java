import java.io.*;
import java.net.*;

public class java_25265_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444); // Bind socket to port 4444
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = serverSocket.accept(); // Accept incoming connection
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Send welcome message
                dos.writeUTF("Welcome to Server!");

                // Receive client message
                String clientMessage = dis.readUTF();
                System.out.println("Client says: " + clientMessage);

                // Close streams and socket connection
                dos.close();
                dis.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}