import java.net.*;
import java.io.*;

public class java_29981_SocketServer_A08 {
    private int port;
    private ServerSocket serverSocket;

    public java_29981_SocketServer_A08(int port) {
        this.port = port;
        startServer();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String clientMessage = dis.readUTF();
                dos.writeUTF("Server received your message: " + clientMessage);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080);
    }
}