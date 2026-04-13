import java.io.*;
import java.net.*;

public class java_21500_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);

            dataOutputStream.writeUTF("Echo: " + message);
            dataOutputStream.flush();

            socket.close();
        }
    }
}