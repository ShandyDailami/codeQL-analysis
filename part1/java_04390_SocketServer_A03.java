import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04390_SocketServer_A03 {
    private final int port;
    private final ServerSocket serverSocket;

    public java_04390_SocketServer_A03(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        System.out.println("Server is listening on port " + port);
        while (!serverSocket.isClosed()) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            // Create a new thread for each client
            Thread clientThread = new Thread(new SocketHandler(clientSocket));
            clientThread.start();
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_04390_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Implement your security sensitive operations here
            // For example, check if the client is coming from the same source as the server
            // If it is not, close the connection and return

            // For now, we'll just close the connection to show the example
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new SecureSocketServer(8080).startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}