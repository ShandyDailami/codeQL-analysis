import java.io.*;
import java.net.*;

public class java_10992_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        while (true) {
            Socket socket = server.accept();

            // Step 1: Send a welcome message
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Welcome to the server!");

            // Step 2: Receive a message from the client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String message = in.readUTF();
            System.out.println("Client says: " + message);

            // Step 3: Send a response back to the client
            out.writeUTF("Thank you for connecting to the server!");

            socket.close();
        }
    }
}