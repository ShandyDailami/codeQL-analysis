import java.io.*;
import java.net.*;

public class java_01838_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client accepted!");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String message = dataInputStream.readUTF();
        System.out.println("Received message: " + message);

        dataOutputStream.writeUTF("Hello client, I'm a Socket Server!");
        dataOutputStream.flush();

        socket.close();
        serverSocket.close();
    }
}