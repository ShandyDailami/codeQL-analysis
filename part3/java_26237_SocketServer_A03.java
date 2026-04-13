import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26237_SocketServer_A03 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        // Step 1: Create a ServerSocket
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        // Step 2: Accept incoming connections
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            // Step 3: Handle the client in a new thread
            new Thread(new ClientHandler(socket)).start();
        }
    }

    static class ClientHandler implements Runnable {

        private final Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Step 4: Handle the client's request
            // This is a simplistic example. In a real application, you would need
            // to parse the request and handle it appropriately. For simplicity,
            // this example simply echoes the client's request back to the client.
            try {
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String request = new String(buffer);
                System.out.println("Received: " + request);

                // Step 5: Send a response back to the client
                String response = "Echo: " + request;
                socket.getOutputStream().write(response.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}