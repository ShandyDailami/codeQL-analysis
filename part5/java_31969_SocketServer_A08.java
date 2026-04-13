import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31969_SocketServer_A08 {

    private static final int PORT = 4999;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected: " + socket.getInetAddress().getHostAddress());

                // Create new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }

        } catch (IOException e) {
            System.out.println("Error in starting server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_31969_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client logic here
            // For the sake of this example, let's say we're just echoing back any received message
            try {
                while ((socket.getInputStream().read()) != -1) {
                    socket.getOutputStream().write("Message received".getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}