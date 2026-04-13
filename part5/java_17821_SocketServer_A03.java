import java.io.*;
import java.net.*;
import java.util.*;

public class java_17821_SocketServer_A03 {

    private static int DEFAULT_PORT = 12345;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        startServer(DEFAULT_PORT);
    }

    public static void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started at port " + port + ". Waiting for client connections...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            handleClient(clientSocket);

            clientSocket.close();
        }
    }

    public static void handleClient(Socket clientSocket) throws IOException {
        OutputStream out = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);

        writer.println("Hello client, I've received your message!");
    }
}