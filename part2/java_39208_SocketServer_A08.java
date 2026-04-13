import java.io.*;
import java.net.*;

public class java_39208_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Client sent: " + message);

            String response = "Hello client, you sent: " + message;
            output.writeUTF(response);

            socket.close();
        }
    }
}