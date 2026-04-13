import java.net.*;
import java.io.*;

public class java_41655_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            String response = "Hello, client!";
            out.writeUTF(response);

            socket.close();
       
        }
    }
}