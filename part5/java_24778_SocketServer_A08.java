import java.io.*;
import java.net.*;

public class java_24778_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            // Create input and output streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Handle client communication
            handleClient(in, out, clientSocket);
            clientSocket.close();
        }
    }

    private static void handleClient(DataInputStream in, DataOutputStream out, Socket clientSocket) throws IOException {
        // Read and send a welcome message
        out.writeUTF("Welcome to the secure server!\n");

        // Read the client's message
        String message = in.readUTF();

        // Check if the client's message is a password
        if (message.equals("password")) {
            out.writeUTF("Access granted!\n");
        } else {
            out.writeUTF("Access denied!\n");
        }

        out.flush();
    }
}