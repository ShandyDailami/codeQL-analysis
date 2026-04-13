import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11556_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Perform security-sensitive operations here

                // Start a new thread to handle the client communication
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server could not bind to port " + PORT + ". Maybe another process is using it?");
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public java_11556_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // Perform operations here
        // ...

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}