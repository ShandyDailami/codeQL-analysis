import java.io.*;
import java.net.*;

public class java_12111_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server started. Waiting for client connection...");

            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMsg = dis.readUTF();
            System.out.println("Client says: " + clientMsg);

            String serverMsg = "Hello, client!";
            dos.writeUTF(serverMsg);
            System.out.println("Server says: " + serverMsg);

            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}