import java.io.*;
import java.net.*;

public class java_32795_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is running and waiting for client connections...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String message = inputStream.readUTF();
            System.out.println("Client says: " + message);

            String response = "Hello, client!";
            outputStream.writeUTF(response);

            socket.close();
        }
    }
}