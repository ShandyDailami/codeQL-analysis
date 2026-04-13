import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_27788_SocketServer_A07 {

    private static ExecutorService executorService;

    public static void main(String[] args) {
        int port = 12345;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            executorService = Executors.newCachedThreadPool();
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                executorService.execute(new ClientHandler(socket));
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
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;

        public java_27788_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {

                int clientMessage;
                while ((clientMessage = input.read()) != -1) {
                    // Perform security-sensitive operations related to A07_AuthFailure
                    // For example, check if client's message is a valid login request
                    // If it's not, send an auth failure response to the client

                    // TODO: Implement security-sensitive operations related to A07_AuthFailure

                    output.write(clientMessage);
                    output.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}