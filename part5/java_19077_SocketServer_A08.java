import java.net.*;
import java.io.*;
import java.util.*;

public class java_19077_SocketServer_A08 {

    private static final int DEFAULT_PORT = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        startServer(DEFAULT_PORT);
    }

    private static void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            handleClient(serverSocket.accept());
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Thank you for connecting to " + clientSocket.getRemoteSocketAddress());

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}