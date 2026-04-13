import java.io.*;
import java.net.*;
import java.util.*;

public class java_15827_SocketServer_A07 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            String response = "Hello, client, your message was: " + message;
            dos.writeUTF(response);
            dos.flush();
        }
    }
}