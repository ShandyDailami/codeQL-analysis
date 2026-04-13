import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36773_SocketServer_A03 {

    private static final int DEFAULT_PORT = 1234;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer(DEFAULT_PORT);
    }

    private static void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at port: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                handleClient(socket);
            }
        } catch (IOException ex) {
            System.out.println("Error occurred while starting server: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    System.out.println("Error occurred while closing server socket: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        // Handle the client connection in a separate thread
        new Thread(new SocketHandler(socket)).start();
    }

    private static class SocketHandler implements Runnable {

        private Socket socket;

        public java_36773_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client request here
        }
    }
}