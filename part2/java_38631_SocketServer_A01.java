import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38631_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_38631_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Perform security-sensitive operations here
                // For example, read and print the client's message
                String message = new String(socket.getInputStream().readNBytes(1024));
                System.out.println("Received message: " + message);

                // Write a response back to the client
                socket.getOutputStream().write("Hello, client!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}