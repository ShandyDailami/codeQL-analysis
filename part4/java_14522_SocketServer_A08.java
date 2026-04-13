import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14522_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running and waiting for client connections on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A client has connected");

            // Create a new thread for communication with the client
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_14522_SocketServer_A08(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // Handle communication with the client
        // This is a minimalist approach and does not include security-sensitive operations
        // You may need to use additional libraries for secure communication
    }
}