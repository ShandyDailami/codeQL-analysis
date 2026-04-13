import java.net.*;
import java.io.*;

public class java_09038_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Client message: " + clientMessage);

            dos.writeUTF("Server message: Hello, client!");
            dos.flush();

            socket.close();
       
        }
    }
}