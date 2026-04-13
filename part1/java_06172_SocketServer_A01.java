import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06172_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                HandleClient thread = new HandleClient(clientSocket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class HandleClient extends Thread {
        private Socket socket;

        public java_06172_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Here you can add code to handle the client connection and perform security-sensitive operations
            // For example, checking if the client is authenticated before serving its request
            // If not, the client can be banned or the connection can be closed
        }
    }
}