import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12853_SocketServer_A08 {
    private static final int DEFAULT_PORT = 12345;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                handleClient(serverSocket.accept());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            // Create a new thread for each client
            new ClientHandler(clientSocket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_12853_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Receive message from client
                byte[] buffer = new byte[1024];
                int bytesRead = clientSocket.getInputStream().read(buffer);
                if (bytesRead < 0) {
                    System.out.println("Closed connection from client");
                    return;
                }

                // Echo back to client
                String response = new String(buffer, 0, bytesRead);
                clientSocket.getOutputStream().write(response.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}