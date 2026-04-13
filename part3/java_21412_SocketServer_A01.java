import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21412_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Create a new thread for each client connection
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening for client connections: " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_21412_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Here you can implement the client-side logic for A01_BrokenAccessControl
            // For example, you can read the request from the client, perform some security-sensitive operations, 
            // and send a response back to the client. You should handle all exceptions and close the connection 
            // when necessary.
            //
            // This part of the code is left as a placeholder for you to implement.
        }
    }
}