import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29647_SocketServer_A07 {

    private static final int PORT = 12345; // Define your port number here

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected from " + socket.getRemoteSocketAddress());
                // Create a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_29647_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client here
        }
    }
}