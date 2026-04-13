import java.io.*;
import java.net.*;

public class java_11111_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            String serverMessage = "Hello, client!";
            dataOutputStream.writeUTF(serverMessage);
            System.out.println("Sent message to client: " + serverMessage);

            socket.close();
        }
    }
}