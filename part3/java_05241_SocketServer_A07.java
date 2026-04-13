import java.net.*;
import java.io.*;

public class java_05241_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        int port = 4444;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server is listening on port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            message = "Hello, Client!";
            out.writeUTF(message);
            System.out.println("Server says: " + message);

            socket.close();
        }
    }
}