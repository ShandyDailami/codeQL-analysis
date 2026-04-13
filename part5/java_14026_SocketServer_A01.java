import java.io.*;
import java.net.*;

public class java_14026_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive a message from client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Send a response
            out.writeUTF("Hello, client!");
            out.flush();

            socket.close();
        }
    }
}