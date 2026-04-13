import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21212_SocketServer_A03 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");

                // Create new thread for each client connection
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_21212_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read and process data from client
                // This is a simple example and does not involve any security-sensitive operations
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                System.out.println(new String(buffer));

                // Send data to client
                String response = "Hello, client!";
                socket.getOutputStream().write(response.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}