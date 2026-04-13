import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11577_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started.");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected.");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
          }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_11577_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Code here for handling the client connection
        }
    }
}