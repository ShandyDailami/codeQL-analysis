import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17238_SocketServer_A08 {

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations here

                // Receive and process data from client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + port);
            e.printStackTrace();
       
            // You can put any cleanup code here
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_17238_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Receive and process data from client
                new ReceiveData(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ReceiveData extends Thread {
        private final Socket socket;

        public java_17238_SocketServer_A08(Socket socket) throws IOException {
            this.socket = socket;
            socket.getInputStream().read(); // Dummy read to get a non-blocking read
        }

        @Override
        public void run() {
            try {
                // Receive data from client
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead != -1) {
                    // Process data received
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}