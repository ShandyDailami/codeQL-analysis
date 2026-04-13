import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_22607_SocketServer_A07 {
    private static ExecutorService executor;
    private static ServerSocketChannel serverChannel;
    private static SSLServerSocket sslServerSocket;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Initialize executor service with a fixed thread pool of 10
        executor = Executors.newFixedThreadPool(10);

        // Set up SSL server socket
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);

        // Accept connections
        serverChannel = ServerSocketChannel.open();
        serverChannel.bind(InetSocketAddress.parseAddress("127.0.0.1:8080"));
        serverChannel.configureBlocking(false);

        System.out.println("Server started on port 8080");

        while (true) {
            SSLSocket client = (SSLSocket) serverChannel.accept();
            client.setNeedClientAuth(true);

            // Start a new thread for each client
            executor.execute(new ClientHandler(client));
        }
    }

    private static class ClientHandler implements Runnable {
        private final SSLSocket client;

        public java_22607_SocketServer_A07(SSLSocket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                InputStream input = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Send a response back to the client
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    writer.println("Hello, client!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Close the client connection
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}