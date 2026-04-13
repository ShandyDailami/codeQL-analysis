import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07532_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a server socket and bind it to port 1234
        ServerSocket server = new ServerSocket(1234);

        System.out.println("Server is listening on port 1234...");

        while (true) {
            // Accept a new client connection
            Socket socket = server.accept();

            System.out.println("Client connected!");

            // Handle the client connection in a separate thread
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;

        public java_07532_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Get input and output streams
            try (socket = new Socket()) {
                socket.connect(new java.net.InetSocketAddress("localhost", 1234));

                // Send a welcome message to the client
                socket.getOutputStream().write("Welcome to the server! Please, log in.".getBytes());

                // Receive the response from the client
                byte[] bytes = new byte[256];
                socket.getInputStream().read(bytes);
                System.out.println("Received message: " + new String(bytes));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}