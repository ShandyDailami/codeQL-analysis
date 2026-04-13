import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22702_SocketServer_A07 {
    private static final int DEFAULT_PORT = 12345;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        startServer(port);
    }

    private static void startServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new SocketHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to setup server: " + e.getMessage());
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket clientSocket;

        public java_22702_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Here, you can add your socket client handling code
                // for example, reading data from the client, handling the request,
                // sending the response, etc.
            } finally {
                clientSocket.close();
            }
        }
    }
}