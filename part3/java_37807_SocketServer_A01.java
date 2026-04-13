import java.io.*;
import java.net.*;

public class java_37807_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Client says: " + message);

            String response = "Hello, Client!";
            dataOutputStream.writeUTF(response);
            System.out.println("Server says: " + response);

            socket.close();
        }
    }
}