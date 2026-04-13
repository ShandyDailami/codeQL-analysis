import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28071_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle the client connection here using threads
            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket clientSocket) {
        // TODO: Handle the client connection and communication with the client
        // You might want to use a BufferedReader and PrintWriter for reading and writing data
        // and then use SSL/TLS to encrypt the communication.
    }
}