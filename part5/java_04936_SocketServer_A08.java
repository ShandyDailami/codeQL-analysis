import java.io.*;
import java.net.*;

public class java_04936_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Receive the message
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Send the message back
            dos.writeUTF(message);
            dos.flush();

            socket.close();
        }
    }
}