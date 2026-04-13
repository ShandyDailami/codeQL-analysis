import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23884_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started, waiting for clients...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted from: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client: " + e.getMessage());
       .
.
.
.
// Rest of the code

ClientHandler.java