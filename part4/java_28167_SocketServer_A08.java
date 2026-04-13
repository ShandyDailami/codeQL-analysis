import java.io.*;
import java.net.*;

public class java_28167_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Waiting for client...");
            Socket socket = server.accept();
            System.out.println("Client accepted!");

            // Write code to handle client connection (socket communication)
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, Client!";
            dos.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}