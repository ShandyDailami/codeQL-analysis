import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08833_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Server could not listen on port " + PORT);
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_08833_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: handle client communication
        }
    }
}