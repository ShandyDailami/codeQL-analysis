import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25269_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

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

        public java_25269_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Accessing the socket directly, which can lead to security issues
            socket.close(); // BrokenAccessControl A01
        }
    }
}