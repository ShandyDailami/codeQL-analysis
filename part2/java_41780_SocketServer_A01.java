import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41780_SocketServer_A01 {

    private static final int PORT = 6000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Start a new thread to handle the client request
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            System.exit(-1);
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_41780_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Here, you can handle the client request, for example, read a message from the client,
                // process it, and send a response back to the client.
                // For example, let's just respond with "Hello, client!"
                String response = "Hello, client!";
                clientSocket.getOutputStream().write(response.getBytes());
            } catch (IOException e) {
                System.err.println("Failed to handle client request");
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Failed to close client socket");
                }
            }
        }
    }
}