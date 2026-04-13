import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33789_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected");

                // Create a new thread for each client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_33789_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Read and handle the request from the client
                byte[] buffer = new byte[1024];
                clientSocket.getInputStream().read(buffer);
                String request = new String(buffer, "UTF-8");
                System.out.println("Received request: " + request);

                // You can perform security-sensitive operations here, like checking if the request contains SQL injection or XSS attacks

                // Send a response back to the client
                String response = "Hello, client!";
                clientSocket.getOutputStream().write(response.getBytes("UTF-8"));
            } catch (IOException e) {
                System.out.println("Client exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}