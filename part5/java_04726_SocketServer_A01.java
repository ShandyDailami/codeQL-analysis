import java.net.*;
import java.io.*;

public class java_04726_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Server: Hello, client!";
            dos.writeUTF(serverMessage);
            System.out.println("Sent: " + serverMessage);

            socket.close();
        }
    }
}