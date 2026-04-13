import java.io.*;
import java.net.*;

public class java_02423_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, you!";
            dataOutputStream.writeUTF(serverMessage);
            dataOutputStream.flush();

            socket.close();
        }
    }
}