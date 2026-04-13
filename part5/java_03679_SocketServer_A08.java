import java.io.*;
import java.net.*;

public class java_03679_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello, client";
            dos.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}