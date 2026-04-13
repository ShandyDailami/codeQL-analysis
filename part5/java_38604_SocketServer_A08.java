import java.io.*;
import java.net.*;
import java.util.*;

public class java_38604_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + ". Message received successfully.");
            out.flush();

            socket.close();
        }
    }
}