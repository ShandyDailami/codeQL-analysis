import java.io.*;
import java.net.*;

public class java_37103_SocketServer_A03 {

    // Main method
    public static void main(String[] args) {
        // Create a new socket server
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started, waiting for connections on port: " + server.getLocalPort());

            // Listen for connections
            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                    // Create input and output streams
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                    // Read and send request
                    String request = dis.readUTF();
                    dos.writeUTF("Hello, Client, your request was: " + request);

                    // Close the connection
                    dos.close();
                    dis.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}