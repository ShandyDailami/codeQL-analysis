import java.net.*;
import java.io.*;

public class java_31299_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        int port = 1234;
        ServerSocket server = new ServerSocket(port);

        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Hello, Client!";
            out.writeUTF(serverMessage);
            System.out.println("Sent: " + serverMessage);

            socket.close();
        }
    }
}