import java.io.*;
import java.net.*;

public class java_10825_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // setting up server
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept(); // waiting for client

            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // reading from client
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            // writing to client
            String serverMessage = "Hello, client, thanks for connecting!";
            dataOutputStream.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();
        }
    }
}