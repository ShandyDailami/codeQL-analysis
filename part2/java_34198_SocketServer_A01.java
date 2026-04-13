import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34198_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a new ServerSocket to listen for connections.
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server started on port 4444.");

            while (true) {
                // Step 2: Wait for a connection.
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected.");

                // Step 3: Create a new Thread to handle communication with the client.
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_34198_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Add code here to handle communication with the client.
            // You may use the socket object to read and write data, or perform additional security-sensitive operations.
        }
    }
}