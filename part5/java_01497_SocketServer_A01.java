import java.io.*;
import java.net.*;
import java.util.*;

public class java_01497_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello, client!";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}