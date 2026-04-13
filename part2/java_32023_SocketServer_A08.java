import java.io.*;
import java.net.*;

public class java_32023_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received message: " + clientMessage);

            String serverMessage = "Hello, client!";
            out.writeUTF(serverMessage);
            System.out.println("Sent message: " + serverMessage);

            socket.close();
        }
    }
}