import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26874_SocketServer_A03 {
    private static final int DEFAULT_PORT = 12345;
    private ServerSocket serverSocket;

    public java_26874_SocketServer_A03() throws IOException {
        this.serverSocket = new ServerSocket(DEFAULT_PORT);
    }

    public void startServer() {
        System.out.println("Starting server on port " + serverSocket.getLocalPort() + "...");

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                // Handle the client connection in a separate thread
                new ClientHandler(clientSocket).start();
            } catch (IOException e) {
                System.out.println("Failed to accept connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer().startServer();
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;

        public java_26874_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            // TODO: Handle client communication
            // This is a simplistic example, and you'll need to implement proper security measures
            // for a production environment
        }
    }
}