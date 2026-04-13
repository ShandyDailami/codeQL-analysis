import java.io.*;
import java.net.*;

public class java_05184_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientInput = dis.readUTF();
            System.out.println("Received: " + clientInput);

            String response = "Hello, Client!";
            dos.writeUTF(response);
            dos.flush();

            socket.close();
        }
    }
}