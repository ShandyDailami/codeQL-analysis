import java.net.*;
import java.io.*;

public class java_13295_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10000);
        System.out.println("Server is listening on port 10000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            output.writeUTF("Server received your message");
            socket.close();
        }
    }
}