import java.io.*;
import java.net.*;

public class java_10788_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

        byte[] buffer = new byte[1024];
        int bytesRead = dataInputStream.read(buffer);
        if (bytesRead < 0) {
            System.out.println("Client disconnected!");
            return;
        }

        String message = new String(buffer, 0, bytesRead);
        System.out.println("Received message: " + message);

        String response = "Hello, client!";
        dataOutputStream.writeUTF(response);
        dataOutputStream.flush();

        clientSocket.close();
        serverSocket.close();
    }
}