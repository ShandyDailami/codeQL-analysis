import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14613_SocketServer_A03 {

    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        // Create a server socket and bind it to the port
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            // Start listening for client connections
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Start a new thread to handle communication with the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_14613_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client communication here
            // You can use InputStream and OutputStream to read and write to and from the client
            // You can also use the socket object to send and receive data
            // However, please note that this is a very basic example and might not be suitable for a real-world application
        }
    }
}