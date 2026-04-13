import java.io.*;
import java.net.*;

public class java_37834_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // create a server socket with port 8080
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String message = inputStream.readUTF(); // read a message from client
            System.out.println("Received message from client: " + message);

            String response = "Hello, client!";
            outputStream.writeUTF(response); // send a response to client

            socket.close();
        }
    }
}