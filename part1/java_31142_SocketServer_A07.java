import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31142_SocketServer_A07 {

    private final static int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Perform authentication here.
                // Assume authentication is successful if IP address is accepted.
                if (socket.getInetAddress().getHostAddress().equals("127.0.0.1")) {
                    new Thread(new ClientHandler(socket)).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {

        private final Socket socket;

        public java_31142_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here.
            // For simplicity, we'll just echo back everything.
            try (socket.getInputStream();
                 socket.getOutputStream()) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}