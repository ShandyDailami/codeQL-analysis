import java.io.*;
import java.net.*;

public class java_13752_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected...");

            // Create streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Get client message
            String clientMessage = input.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            // Send back message to client
            output.writeUTF("Message received, thanks for connecting!");
            output.flush();

            // Close streams
            input.close();
            output.close();
            socket.close();
        }
    }
}