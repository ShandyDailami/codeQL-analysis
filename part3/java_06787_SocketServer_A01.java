import java.net.*;
import java.io.*;

public class java_06787_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started at port 12345");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, Client!";
            dos.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();
        }
    }
}