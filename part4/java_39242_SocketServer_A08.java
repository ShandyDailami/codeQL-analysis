import java.io.*;
import java.net.*;

public class java_39242_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Message from client: " + message);

            String response = "Message received";
            dataOutputStream.writeUTF(response);

            socket.close();
        }
    }
}