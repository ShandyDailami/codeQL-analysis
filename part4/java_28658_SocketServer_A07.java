import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28658_SocketServer_A07 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Process the request in a new thread
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start");
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_28658_SocketServer_A07(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // TODO: Implement authentication and data processing here.
    }
}