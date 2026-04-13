import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09533_SocketServer_A01 {
    private static final int DEFAULT_PORT = 1234;
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        System.out.println("Starting server at port " + port);

        serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new client from " + clientSocket.getRemoteSocketAddress());

            // Create a new thread for each client
            new HandleClient(clientSocket).start();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.start(DEFAULT_PORT);
    }

    private class HandleClient extends Thread {
        private Socket clientSocket;

        public java_09533_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            // Handle the client connection here...
            // This is a placeholder, replace this with actual code
            System.out.println("Handling client connection...");
        }
    }
}