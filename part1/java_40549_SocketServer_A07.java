import java.io.*;
import java.net.*;

public class java_40549_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started at port 1234");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Start by sending a welcome message
            out.writeUTF("Welcome to the server!");

            // Read the message from the client
            String message = in.readUTF();
            System.out.println("Received from client: " + message);

            // Check if the message is valid (e.g., "Hello, client" is the only valid message)
            if ("Hello, client".equals(message)) {
                // If the message is valid, send a success message back to the client
                out.writeUTF("Success!");
            } else {
                // If the message is not valid, send an auth failure message back to the client
                out.writeUTF("Auth failure!");
            }

            out.flush();
            socket.close();
        }
    }
}