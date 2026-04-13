import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_22584_SocketServer_A08 {
    private static final int SERVER_PORT = 9999;
    private static final int POOL_SIZE = 10;

    public static void main(String[] args) throws Exception {
        // Create a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        // Create a server socket
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(SERVER_PORT);
            System.out.println("Server listening on port " + SERVER_PORT);

            while (true) {
                // Block and wait for a connection
                Socket socket = serverSocket.accept();

                // Create a new handler thread for this client
                ServerHandler handler = new ServerHandler(socket);
                executor.execute(handler);
            }
        } finally {
            // Close the server socket
            serverSocket.close();
        }
    }

    private static class ServerHandler implements Runnable {
        private final Socket socket;

        ServerHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create a new SSL socket
                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress());
                sslSocket.setNeedClientAuthentication(true);

                // Connect to the remote host
                sslSocket.connect();

                // Send a message to the remote host
                sslSocket.getOutputStream().write("Hello, client!".getBytes());
                sslSocket.getOutputStream().flush();

                // Read the message from the remote host
                byte[] bytes = new byte[1024];
                int readBytes = sslSocket.getInputStream().read(bytes);
                System.out.println("Server received: " + new String(bytes, 0, readBytes));

                // Close the socket
                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}