import java.io.*;
import java.net.*;

public class java_23722_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 4445;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String message;

            while ((message = inputStream.readUTF()) != null) {
                System.out.println("Received client: " + message);
                outputStream.writeUTF("Server: Message received");
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}