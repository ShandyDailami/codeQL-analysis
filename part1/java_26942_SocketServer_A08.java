import java.io.*;
import java.net.*;
import java.util.*;

public class java_26942_SocketServer_A08 {
    private static final int DEFAULT_PORT = 8080;
    private static final String QUIT = "quit";

    private Socket socket;
    private ServerSocket serverSocket;

    public java_26942_SocketServer_A08() throws IOException {
        this(DEFAULT_PORT);
    }

    public java_26942_SocketServer_A08(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            socket = serverSocket.accept();
            System.out.println("Accepted a new connection from " + socket.getRemoteSocketAddress());
            handle(socket);
        }
    }

    private void handle(Socket socket) {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String request = in.readUTF();
            if (request.equals(QUIT)) {
                out.writeUTF("Goodbye, client!");
                socket.close();
            } else {
                out.writeUTF("Hello, client!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer();
    }
}