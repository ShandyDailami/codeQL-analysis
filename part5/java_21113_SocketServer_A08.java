import java.io.*;
import java.net.*;

public class java_21113_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message
            out.writeUTF("Welcome to the server!");

            // Receive client's message and respond
            String clientMessage = in.readUTF();
            out.writeUTF("Received your message: " + clientMessage);

            socket.close();
       
        }
    }
}