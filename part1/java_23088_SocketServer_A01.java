import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23088_SocketServer_A01 {
    private static final int PORT = 12345; // define your port number here

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT); // create the server socket
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // wait for a client to connect
                System.out.println("Client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public java_23088_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here
    }
}