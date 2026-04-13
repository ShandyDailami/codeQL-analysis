import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13248_SocketServer_A01 {

    private static final int SERVER_PORT = 9876;
    private static final String CORRECT_PASSWORD = "securePassword";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started, waiting for client connections on port: " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Start a new thread to handle communication with the client
                HandlerThread handlerThread = new HandlerThread(socket);
                handlerThread.start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start due to: " + e.getMessage());
        }
    }

    private static class HandlerThread extends Thread {
        private Socket socket;

        public java_13248_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read the password from the client
                byte[] bytes = new byte[socket.getInputStream().available()];
                socket.getInputStream().read(bytes);
                String password = new String(bytes);

                // Check if the password is correct
                if (password.equals(CORRECT_PASSWORD)) {
                    System.out.println("Access granted, performing necessary operations");
                    // Perform operations related to Broken Access Control here
                    // ...
                } else {
                    System.out.println("Access denied, breaking the connection");
                    // In case the password is incorrect, break the connection
                    socket.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred during the communication: " + e.getMessage());
            }
        }
    }
}