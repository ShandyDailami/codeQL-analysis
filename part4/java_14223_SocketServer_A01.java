import java.io.*;
import java.net.*;

public class java_14223_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started at " + serverSocket.getLocalSocketAddress());

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String message = inputStream.readUTF();
            System.out.println("Received message: " + message);

            String response = "Hello, Client!";
            outputStream.writeUTF(response);
            System.out.println("Sent message: " + response);

            socket.close();
        }
    }
}