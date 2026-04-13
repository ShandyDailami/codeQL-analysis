import java.io.*;
import java.net.*;

public class java_15825_SocketServer_A08 {
    private static final String SERVER_MESSAGE = "Thank you for connecting to the Socket Server!";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(SERVER_PORT);

        System.out.println("Server is listening on port: " + SERVER_PORT);

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(SERVER_MESSAGE);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String clientMessage = inputStream.readUTF();

            System.out.println("Client said: " + clientMessage);

            socket.close();
        }
    }
}