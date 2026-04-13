import java.io.*;
import java.net.*;

public class java_36807_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            String serverMessage = "Server Message";
            out.writeUTF(serverMessage);
            System.out.println("Sent message to client: " + serverMessage);

            socket.close();
        }
    }
}