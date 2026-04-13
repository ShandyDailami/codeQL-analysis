import java.io.*;
import java.net.*;

public class java_24098_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Server says: Hello, client!";
            dos.writeUTF(serverMessage);
            System.out.println("Sent: " + serverMessage);

            socket.close();
        }
    }
}