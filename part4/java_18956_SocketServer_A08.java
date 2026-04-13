import java.io.*;
import java.net.*;

public class java_18956_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for client on port " + server.getLocalPort() + "...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Connection established!");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Server received: " + inputStream.readUTF());

            socket.close();
        }
    }
}