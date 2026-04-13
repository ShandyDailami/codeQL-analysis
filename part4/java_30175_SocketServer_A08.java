import java.io.*;
import java.net.*;

public class java_30175_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String message = inputStream.readUTF();
            System.out.println("Received message: " + message);

            outputStream.writeUTF("Server received the message: " + message);
            outputStream.flush();

            socket.close();
        }
    }
}