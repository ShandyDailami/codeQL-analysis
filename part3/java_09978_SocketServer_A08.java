import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_09978_SocketServer_A08 {

    private final ExecutorService executor;
    private final ServerSocket serverSocket;
    private volatile boolean running = true;

    public java_09978_SocketServer_A08(int port) throws IOException {
        this.executor = Executors.newCachedThreadPool();
        this.serverSocket = new ServerSocket(port);
    }

    public void start() {
        System.out.println("Server started on port " + serverSocket.getLocalPort());
        while (running) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new client from " + clientSocket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                if (!running) {
                    System.err.println("Closing down the server");
                    executor.shutdown();
                    serverSocket.close();
                } else {
                    System.err.println("Failed to accept connection, port " + serverSocket.getLocalPort() + " is probably in use.");
                }
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
        executor.shutdown();
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_09978_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (InputStream in = clientSocket.getInputStream();
                 OutputStream out = clientSocket.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead = in.read(buffer);
                if (bytesRead < 0) {
                    clientSocket.close();
                    return;
                }
                // Here is where you would add your security-sensitive operations related to A08_IntegrityFailure
                // For example, you could add a checksum to verify the integrity of the data received.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}