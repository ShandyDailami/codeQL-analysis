import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36768_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is running and waiting for connections on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected");

                // Create a new thread for each client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + PORT);
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_36768_SocketServer_A03(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection here
        // You can create a new thread for each message from the client
        // This is where you can add security-sensitive operations related to A03_Injection
    }
}