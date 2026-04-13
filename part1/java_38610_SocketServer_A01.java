import java.io.*;
import java.net.*;

public class java_38610_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Receive request
            String request = input.readUTF();
            System.out.println("Received request: " + request);

            // Send response
            output.writeUTF("Welcome to secure server!");
            output.flush();

            // Close streams
            input.close();
            output.close();
            socket.close();
        }
    }
}