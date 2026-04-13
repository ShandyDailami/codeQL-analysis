import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01891_SocketServer_A03 {
    private int port;

    public java_01891_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server on port: " + port);
            e.printStackTrace();
        }
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;

        public java_01891_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Here you can handle client communication
                // For example, read from and write to the client
            } finally {
                clientSocket.close();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).start();
    }
}