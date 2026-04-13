import java.io.*;
import java.net.*;

public class java_28919_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            String serverMessage = "Server message from " + socket.getLocalSocketAddress();
            dos.writeUTF(serverMessage);
            System.out.println("Sent message to client: " + serverMessage);

            socket.close();
        }
    }
}