import java.io.*;
import java.net.*;

public class java_19427_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String clientMsg = dis.readUTF();
        System.out.println("Received client message: " + clientMsg);

        String serverMsg = "Hello client, you connected successfully!";
        dos.writeUTF(serverMsg);

        System.out.println("Server message sent");

        socket.close();
        server.close();
    }
}