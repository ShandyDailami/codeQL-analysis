import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11756_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Handle client connection in a new thread
                new HandlerThread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandlerThread extends Thread {
        private Socket clientSocket;

        public java_11756_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Here, we can perform operations related to A01_BrokenAccessControl
                // For instance, we can read and send data to and from the client
                byte[] bytes = new byte[1024];
                clientSocket.getInputStream().read(bytes);
                clientSocket.getOutputStream().write(bytes);
                clientSocket.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}