import java.net.*;
import java.io.*;

public class java_23184_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("close")) {
                dos.writeUTF("Connection closed by client");
                socket.close();
            } else {
                dos.writeUTF("Server received your message: " + message);
            }

            dos.close();
            socket.close();
        }
    }
}