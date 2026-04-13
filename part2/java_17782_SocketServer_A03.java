import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17782_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Create a ServerSocket
            serverSocket = new ServerSocket(PORT, 50, InetAddress.getByName("localhost"));
            System.out.println("Server started on port " + PORT);
        } catch (IOException e) {
            System.out.println("Server could not start on port " + PORT);
            e.printStackTrace();
            System.exit(-1);
        }

        // Infinite loop to accept new clients
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Creating a new thread for each client
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            } catch (IOException e) {
                System.out.println("Client connection interrupted");
                e.printStackTrace();
            }
        }
    }
}