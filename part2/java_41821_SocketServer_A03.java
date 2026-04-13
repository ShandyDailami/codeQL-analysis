import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41821_SocketServer_A03 {

    private int port;

    public java_41821_SocketServer_A03(int port) {
        this.port = port;
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println("Error while setting up server: " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_41821_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // TODO: Handle the client communication
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(5000);
        server.startServer();
    }
}