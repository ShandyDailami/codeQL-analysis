import java.io.*;
import java.net.*;

public class java_23130_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is running and waiting for client connection...");

            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello Client!";
            dos.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}