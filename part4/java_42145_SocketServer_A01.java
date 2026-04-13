import java.io.*;
import java.net.*;

public class java_42145_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read request from client
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Send response
            String response = "Hello, client!";
            out.writeUTF(response);

            socket.close();
        }
    }
}