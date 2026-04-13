import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_34563_SocketServer_A07 {
    private final static int PORT = 8888;
    private final static String CLIENT_IDENTIFIER = "SSLClient";

    public static void main(String[] args) throws IOException {
        // Create executor for handling multiple clients
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Create server socket using SSL
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

        System.out.println("Server is running on port " + PORT);

        while (true) {
            // Accept client
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            // Initialize stream
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

            // Create new client thread
            ClientHandler clientHandler = new ClientHandler(in, out, sslSocket, CLIENT_IDENTIFIER);
            executorService.execute(clientHandler);
        }
    }

    static class ClientHandler implements Runnable {
        private final BufferedReader in;
        private final PrintWriter out;
        private final SSLSocket sock;
        private final String clientIdentifier;

        ClientHandler(BufferedReader in, PrintWriter out, SSLSocket sock, String clientIdentifier) {
            this.in = in;
            this.out = out;
            this.sock = sock;
            this.clientIdentifier = clientIdentifier;
        }

        @Override
        public void run() {
            String message;

            // Read message
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Write back
                    out.println("Server says: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(in);
                close(out);
                sock.close();
            }
        }

        private void close(Closeable closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                // Ignore exception
            }
        }
    }
}