import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20832_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000); // Setting up server port
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept(); // Accepting client connection
            System.out.println("Client connected");

            // Get streams from socket
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Reading message from client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Sending response back to client
            String response = "Hello, client";
            output.writeUTF(response);
            output.flush();

            // Close socket
            socket.close();
        }
    }
}