import java.io.*;
import java.net.*;
import java.util.*;

public class java_22221_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Server response: " + clientMessage;
            dataOutputStream.writeUTF(serverMessage);

            socket.close();
        }
    }
}