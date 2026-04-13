import java.io.*;
import java.net.*;

public class java_24197_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Waiting for client...");

            Socket socket = server.accept();
            System.out.println("Client accepted!");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMsg = dis.readUTF();
            System.out.println("Client says: " + clientMsg);

            String serverMsg = "Hello, Client!";
            dos.writeUTF(serverMsg);
            System.out.println("Server says: " + serverMsg);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}