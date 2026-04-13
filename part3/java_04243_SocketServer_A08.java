import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04243_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        int port = 8080; // default port
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Create new threads for each client
                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_04243_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Handle client here
        }
    }
}