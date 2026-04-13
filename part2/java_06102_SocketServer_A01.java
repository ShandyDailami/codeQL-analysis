import java.io.*;
import java.net.*;

public class java_06102_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Reading the message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Sending a response
            String response = "Hello, Client!";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}