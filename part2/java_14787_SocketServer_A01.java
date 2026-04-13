import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14787_SocketServer_A01 {

    private static final int PORT = 8000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Create a new thread for each client
            Thread clientThread = new Thread(new ClientHandler(socket));
            clientThread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_14787_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here
            // For example, print out what client sent
            System.out.println("Client sent: " + socket.getInputStream().readUTF());

            // Send a response back to the client
            socket.getOutputStream().writeUTF("Hello, client!");
            socket.getOutputStream().flush();
        }
    }
}