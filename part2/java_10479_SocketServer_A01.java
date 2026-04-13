import java.io.*;
import java.net.*;

public class java_10479_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);

            dataOutputStream.writeUTF("Hello client, you are connected to server!");
            System.out.println("Sent message: Hello client, you are connected to server!");

            socket.close();
        }
    }
}