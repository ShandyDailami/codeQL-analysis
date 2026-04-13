import java.io.*;
import java.net.*;

public class java_06057_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String message = inputStream.readUTF();
            System.out.println("Received message from client: " + message);

            outputStream.writeUTF("Message received");
            outputStream.flush();

            socket.close();
        }
    }
}