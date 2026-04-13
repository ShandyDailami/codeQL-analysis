import java.io.*;
import java.net.*;

public class java_08065_SocketServer_A01 {
    private static int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is listening on port: " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send response to client
            String response = "Hello, client!";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}