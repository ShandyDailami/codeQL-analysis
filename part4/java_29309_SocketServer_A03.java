import java.io.*;
import java.net.*;

public class java_29309_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String message = dataInputStream.readUTF();
            System.out.println("Received: " + message);
            dataOutputStream.writeUTF("Message received");
            socket.close();
        }
    }
}