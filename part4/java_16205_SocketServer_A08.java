import java.io.*;
import java.net.*;

public class java_16205_SocketServer_A08 {
    private static final int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connection successful!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println("Client says: " + in.readUTF());

            socket.close();
        }
    }
}