import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28547_SocketServer_A01 {
    private static final int PORT = 12345; // You can change this port to any unused port

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Start a new thread for the client
            new ClientHandler(clientSocket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public java_28547_SocketServer_A01(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here
        // For example, you could read from and write to the client
    }
}