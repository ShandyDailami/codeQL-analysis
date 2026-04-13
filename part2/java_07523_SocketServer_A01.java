import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07523_SocketServer_A01 {
    private static final int PORT = 9999;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        System.out.println("Server is listening on port " + PORT + "...");
        startServer();
    }

    private static void startServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeServer();
        }
    }

    private static void closeServer() {
        System.out.println("Server is shutting down...");
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server has been closed!");
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_07523_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Perform Denial of Service (DoS) attack
            while (true) {
                try {
                    socket.getInputStream().read();
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
            closeConnection();
        }

        private void closeConnection() {
            System.out.println("Client " + socket.getRemoteSocketAddress() + " disconnected");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}