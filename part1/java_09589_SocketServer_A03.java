import java.io.*;
import java.net.*;

public class java_09589_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);

        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Here's where we have a security-sensitive operation.
            // This is just to demonstrate the concept of Injection.
            // It's not a realistic example but it's the best we can do.
            String userInput = "Your message: " + message;

            out.writeUTF(userInput);
            out.flush();
       
            socket.close();
        }
    }
}