import java.io.*;
import java.net.*;

public class java_33312_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Connection established");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String clientMessage = inputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            socket.close();
        }
    }
}