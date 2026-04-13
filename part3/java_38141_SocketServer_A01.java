import java.io.*;
import java.net.*;

public class java_38141_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            // Read and send data to client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            // Security-sensitive operation - BrokenAccessControl
            // The message is reversed for security purposes
            String reversedMessage = new StringBuilder(message).reverse().toString();
            out.writeUTF(reversedMessage);

            socket.close();
        }
    }
}