import java.io.*;
import java.net.*;

public class java_03156_SocketServer_A08 {
    private int port;
    private ServerSocket serverSocket;

    public java_03156_SocketServer_A08(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Server started on port: " + port);
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                out.writeUTF("Welcome to the server!");

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                System.out.println("Client said: " + in.readUTF());

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(9999);
        server.start();
    }
}