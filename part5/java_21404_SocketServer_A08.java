import java.io.*;
import java.net.*;

public class java_21404_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Hello, Client!");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println(in.readUTF());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}