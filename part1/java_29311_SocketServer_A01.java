import java.io.*;
import java.net.*;

public class java_29311_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received message: " + clientMessage);

            String serverMessage = "Hello, Client!";
            dataOutputStream.writeUTF(serverMessage);
            System.out.println("Sent message to the client: " + serverMessage);

            socket.close();
        }
    }
}