import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15332_SocketServer_A08 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        System.out.println("Server started...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_15332_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Implement the logic for receiving and verifying the integrity of the message
            // You can use a secure channel (like SSL/TLS) to ensure the integrity of the data
            // For the purpose of this example, we'll just echo back the message
            try (socket.getInputStream();
                 socket.getOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead < 0) {
                    System.out.println("Client disconnected!");
                    return;
                }

                // TODO: Use the received data (buffer) for further processing or for other operations
                // For the purpose of this example, we'll just echo back the message
                socket.getOutputStream().write(buffer);
                socket.getOutputStream().flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}