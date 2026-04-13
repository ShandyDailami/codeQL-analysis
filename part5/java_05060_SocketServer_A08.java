import java.io.*;
import java.net.*;

public class java_05060_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String message = dis.readUTF();
        System.out.println("Received: " + message);

        dos.writeUTF("Message received");
        dos.flush();

        socket.close();
        serverSocket.close();
    }
}