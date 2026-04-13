import java.io.*;
import java.net.*;

public class java_24459_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Hello, client!");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String clientMessage = inputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            socket.close();
        }
    }
}