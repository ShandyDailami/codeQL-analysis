import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_36401_SocketServer_A08 {

    private static final int PORT = 8080;
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
        serverSocket.setNeedClientAuthentication(true);

        System.out.println("Server started on port: " + PORT);

        while (true) {
            final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    private static class ClientHandler implements Runnable {
        private final SSLSocket socket;

        ClientHandler(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client communication here
            // For example, print out the client's request and send back a response
            System.out.println("Client request: " + socket.getInputStream().toString());
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());
            socket.close();
        }
    }
}