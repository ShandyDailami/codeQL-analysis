import java.io.*;
import java.net.*;

public class java_01185_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello, client!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            String message = in.readUTF();
            System.out.println("Received from client: " + message);

            socket.close();
        }
    }
}