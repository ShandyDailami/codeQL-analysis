import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20207_SocketServer_A03 {

    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_20207_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here
            // For now, just print out the client's IP address
            System.out.println("Client IP: " + socket.getInetAddress().getHostAddress());

            // TODO: Add code here to handle client communication, such as reading and writing data
            // For the sake of this example, we'll just echo back any received data
            try {
                // Receive message from client
                byte[] bytes = new byte[1024];
                socket.getInputStream().read(bytes);
                String message = new String(bytes);

                // Send message back to client
                socket.getOutputStream().write(message.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}