import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30440_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Start a new thread to handle the client request
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private final Socket socket;

        public java_30440_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket) {
                // Handle the client request here
                // For simplicity, we will just print out the received data
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                String receivedData = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + receivedData);

                // Send a response back to the client
                socket.getOutputStream().write("Hello, client!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}