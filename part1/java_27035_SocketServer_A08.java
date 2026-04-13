import java.io.*;
import java.net.*;

public class java_27035_SocketServer_A08 {
    private static final int DEFAULT_PORT = 8888;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        startServer(DEFAULT_PORT);
    }

    public static void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            handleClient(serverSocket.accept());
        }
    }

    public static void handleClient(Socket clientSocket) throws IOException {
        System.out.println("Handling client connection");
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            out.println("Server received your message");
        }

        out.close();
        in.close();
        clientSocket.close();

        System.out.println("Client disconnected");
    }
}