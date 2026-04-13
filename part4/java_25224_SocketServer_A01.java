import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25224_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            // Create a new thread to handle the client request
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_25224_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client request here
            // For simplicity, we'll just echo the received message back to the client
            try {
                while ((socket.getInputStream().read()) != -1) ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}