import java.io.*;
import java.net.*;

public class java_29332_SocketServer_A07 {
    private static final int port = 8888;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client connection...");
            socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String message = in.readUTF();
                System.out.println("Received: " + message);
                if (message.equals("exit")) {
                    System.out.println("Exiting...");
                    out.writeUTF("Goodbye");
                    break;
                }
                out.writeUTF("Hello, client");
            }
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}