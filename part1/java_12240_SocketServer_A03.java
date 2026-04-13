import java.io.*;
import java.net.*;

public class java_12240_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Server started at port 8000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello Client, You are connected!";
            dos.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();
        }
    }
}