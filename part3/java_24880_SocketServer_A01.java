import java.io.*;
import java.net.*;

public class java_24880_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started on port 4444");

            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            String response = "Hello, client!";
            out.writeUTF(response);
            System.out.println("Sent message to client: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}