import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40622_SocketServer_A03 {

    private int port;
    private ServerSocket server;

    public java_40622_SocketServer_A03(int port) {
        this.port = port;
        this.server = null;
    }

    public void start() {
        try {
            server = new ServerSocket(port);
            while(true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                // Handle client connection in a new thread
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Server could not be established. Port: " + port);
            e.printStackTrace();
        } finally {
            // Close server
            try {
                server.close();
            } catch (IOException e) {
                System.out.println("Could not close server");
                e.printStackTrace();
            }
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_40622_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Handle client request and response in a try-with-resources statement
            try (SocketClientWrapper client = new SocketClientWrapper(clientSocket)) {
                // Here you can handle the request from the client
                System.out.println("Client says: " + client.readLine());
                // Here you can send a response
                client.write("Server says: Hello Client!");
            } catch (IOException e) {
                System.out.println("Error handling client: " + clientSocket.getInetAddress().getHostAddress());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SecureSocketServer server = new SecureSocketServer(5000);
        server.start();
    }
}