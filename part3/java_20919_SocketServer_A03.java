import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20919_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected");

                // Create a new thread for each client
                Thread clientThread = new Thread(new ClientHandler(socket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_20919_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // TODO: Add code here for handling the client connection.
            // This is a placeholder. You should add your own code for handling the client connection.
            System.out.println("Handling client connection...");

            // Close the socket after handling the client connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}