import java.io.*;
import java.net.*;

public class java_28080_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Connected!");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String message;

        while ((message = dis.readUTF()) != null) {
            System.out.println("Received: " + message);
            dos.writeUTF("Thank you for connecting to " + socket.getInetAddress().getHostAddress());
        }
        socket.close();
    }
}