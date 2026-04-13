import java.io.*;
import java.net.*;

public class java_31035_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client connected!");

            // Handle client connection in a new thread
            new Thread(() -> {
                try {
                    // Create streams for reading and writing
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    // Read request from client
                    String request = in.readUTF();
                    System.out.println("Received request: " + request);

                    // Send response to client
                    out.writeUTF("Server received your request");
                    out.flush();

                    // Close streams
                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}