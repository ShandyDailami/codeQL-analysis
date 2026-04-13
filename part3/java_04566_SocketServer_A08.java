import java.io.*;
import java.net.*;

public class java_04566_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client on port " + port);

            socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            out.writeUTF("Server says: Hello, Client!");
            out.flush();

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}