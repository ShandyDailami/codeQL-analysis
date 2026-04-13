import java.io.*;
import java.net.*;

public class java_14884_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Connection established");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String clientMessage = dis.readUTF();
            System.out.println("Client message: " + clientMessage);

            socket.close();
        }
    }
}