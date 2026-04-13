import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21861_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_21861_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Perform security-sensitive operations here
                // For example, read a file and verify its integrity
                // This is a placeholder, replace it with actual code
                byte[] bytes = new byte[1024];
                clientSocket.getInputStream().read(bytes, 0, 1024);

                // Now, for the sake of simplicity, let's assume this operation
                // was successful and the client is authenticated.
                System.out.println("Client authenticated successfully!");

                // Now, for the sake of simplicity, let's send a simple response
                // to the client.
                clientSocket.getOutputStream().write("Hello, client!".getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}