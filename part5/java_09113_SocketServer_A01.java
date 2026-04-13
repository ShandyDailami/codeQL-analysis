import java.io.*;
import java.net.*;

public class java_09113_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while(true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received message: " + clientMessage);

            String serverMessage = "Hello, client!";
            out.writeUTF(serverMessage);
            System.out.println("Sent message: " + serverMessage);

            socket.close();
        }
    }
}