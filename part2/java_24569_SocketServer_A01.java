import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24569_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected");

                // Start a new thread for each client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Server could not start due to " + e.getMessage());
        }
    }

    // Inner class for handling each client connection
    private static class ClientHandler extends Thread {
        private Socket clientSocket;

        public java_24569_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Here, we should implement the secure communication
                // For now, let's just echo back everything
                while ((clientSocket.getInputStream().read()) != -1) ;
            } catch (IOException e) {
                System.out.println("Client disconnected");
            }
        }
    }
}