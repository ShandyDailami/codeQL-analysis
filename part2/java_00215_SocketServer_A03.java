import java.io.*;
import java.net.*;

public class java_00215_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345); // Port number
        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Received client message: " + clientMessage);

            String serverMessage = "Server received the message: " + clientMessage;
            dos.writeUTF(serverMessage);
            System.out.println("Sent server message: " + serverMessage);

            socket.close();
        }
    }
}