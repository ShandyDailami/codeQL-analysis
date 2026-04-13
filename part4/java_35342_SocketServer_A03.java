import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35342_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
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

        public java_35342_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Receive data from the client
                byte[] buffer = new byte[1024];
                int bytesRead = clientSocket.getInputStream().read(buffer);

                if (bytesRead < 0) {
                    System.out.println("Client disconnected!");
                    return;
                }

                // Process the data (e.g., send back the same data to the client)
                byte[] response = ("Server says: " + new String(buffer, 0, bytesRead)).getBytes();
                clientSocket.getOutputStream().write(response);
                clientSocket.getOutputStream().flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}