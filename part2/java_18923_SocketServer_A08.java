import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18923_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread to handle the client request
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_18923_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Receive message from client
                byte[] bytes = new byte[1024];
                int length = clientSocket.getInputStream().read(bytes);
                String message = new String(bytes, 0, length);
                System.out.println("Received message: " + message);

                // Send message back to client
                clientSocket.getOutputStream().write(message.getBytes());
                clientSocket.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}