import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28868_SocketServer_A03 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // handle the connection here, for example, by starting a new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_28868_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle client communication here, for example, by reading and writing data
            // handle the connection securely by using SSL/TLS for data encryption
            // and by implementing authentication and authorization
        }
    }
}