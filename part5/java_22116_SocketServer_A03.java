import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22116_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Handle the client connection here
                // For simplicity, we're just sending back a message
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_22116_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client's request here
            // For simplicity, we're just sending back a message
            try {
                socket.getOutputStream().write("Hello, Client!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}