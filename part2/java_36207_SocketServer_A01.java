import java.io.*;
import java.net.*;
import java.util.*;

public class java_36207_SocketServer_A01 {
    private static final String SERVER_SOCKET = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started.");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected.");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received: " + request);

                // TODO: Add your security-sensitive operations here.

                String response = "Server accepted your request.";
                out.writeUTF(response);
                System.out.println("Sent: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}