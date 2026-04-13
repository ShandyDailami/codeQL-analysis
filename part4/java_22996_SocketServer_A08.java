import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22996_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4000);
            System.out.println("Server started at port 4000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create new thread for handling the client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_22996_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client
            // Implement your security-sensitive operations here
            // For example, check the integrity of the received data
        }
    }
}