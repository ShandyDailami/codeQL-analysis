import java.io.*;
import java.net.*;

public class java_18378_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server started at port 6000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client connected");

                // Create streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Handle client
                String clientMessage = dis.readUTF();
                System.out.println("Received message: " + clientMessage);

                String serverMessage = "Hello, Client!";
                dos.writeUTF(serverMessage);
                System.out.println("Server sends message: " + serverMessage);

                // Close connections
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}