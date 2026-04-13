import java.io.*;
import java.net.*;

public class java_08120_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMsg = in.readUTF();
            System.out.println("Client says: " + clientMsg);

            String serverMsg = "Hello, Client!";
            out.writeUTF(serverMsg);
            System.out.println("Server says: " + serverMsg);

            socket.close();
        }
    }
}