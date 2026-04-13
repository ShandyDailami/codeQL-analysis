import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32680_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_32680_SocketServer_A03(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here using a secure channel like SSL
    }
}