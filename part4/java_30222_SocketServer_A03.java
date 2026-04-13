import java.io.*;
import java.net.*;

public class java_30222_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started, waiting for connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Message received: " + message);

            output.writeUTF("Server received your message: " + message);
            output.flush();
            socket.close();
        }
    }
}