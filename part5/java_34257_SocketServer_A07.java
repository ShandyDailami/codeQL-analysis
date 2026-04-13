import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34257_SocketServer_A07 {

    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server started on port " + SERVER_PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Here you should implement the authentication process
            // For simplicity, we'll assume that authentication is successful
            if (authenticate(clientSocket)) {
                new Thread(new ClientHandler(clientSocket)).start();
            } else {
                clientSocket.close();
                System.out.println("Authentication failed for " + clientSocket.getRemoteSocketAddress());
            }
        }
    }

    // Method to handle authentication
    private static boolean authenticate(Socket clientSocket) {
        // Here you should implement your authentication logic
        // For simplicity, we'll always return true
        return true;
    }

    private static class ClientHandler implements Runnable {

        private final Socket clientSocket;

        public java_34257_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Handle client communication here
            // For simplicity, we'll echo back everything received from the client
            try {
                while ((clientSocket.getInputStream().read()) != -1) ;
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}