import java.io.*;
import java.net.*;

public class java_27589_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started.");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                // Create a new thread for each connection
                new Thread(() -> handleConnection(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleConnection(Socket socket) {
        try {
            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send response back to client
            out.writeUTF("Server received your message: " + message);
            out.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}