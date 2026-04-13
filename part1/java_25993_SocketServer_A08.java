import java.io.*;
import java.net.*;

public class java_25993_SocketServer_A08 {
    private static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            dataOutputStream.writeUTF("Server says: " + clientMessage);
            dataOutputStream.flush();

            socket.close();
        }
    }
}