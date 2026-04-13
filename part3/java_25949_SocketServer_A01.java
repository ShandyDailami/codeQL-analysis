import java.io.*;
import java.net.*;

public class java_25949_SocketServer_A01 {
    private static final String CLIENT_IDENTIFIER = "CLIENT";
    private static final int PORT = 8189;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started with port number: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, " + clientMessage;
            dataOutputStream.writeUTF(serverMessage);
            dataOutputStream.flush();

            socket.close();
        }
    }
}