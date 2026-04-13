import java.net.ServerSocket;
import java.net.Socket;

public class java_39866_SocketServer_A01 {

    private static final int PORT = 5000;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client connected");

            // For demonstration purposes, we're not actually dealing with the client
            // We're just creating a new thread for each client
            new Thread(new ClientHandler(socket)).start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_39866_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Here you can perform any operations related to the client, such as reading from and writing to the client
        }
    }
}