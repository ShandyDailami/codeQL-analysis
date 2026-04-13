import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_26918_SocketServer_A01 {

    private static ExecutorService executor;
    private static int port = 8080;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;

        try {
            // Create a SSLServerSocket for the specified port.
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            serverSocket.setNeedClientAuthentication(true);

            executor = Executors.newFixedThreadPool(10);

            while (true) {
                final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                executor.execute(new SocketReader(clientSocket));
            }
        } catch (SSLException e) {
            System.err.println("SSL Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Shutdown executor
            executor.shutdown();

            // Close the server socket and clean up resources
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    // SocketReader is a Runnable for each client connection
    private static class SocketReader implements Runnable {
        private final BufferedReader reader;
        private final SSLSocket sock;

        public java_26918_SocketServer_A01(SSLSocket sock) {
            this.sock = sock;
            InputStreamReader in = new InputStreamReader(sock.getInputStream());
            this.reader = new BufferedReader(in);
        }

        public void run() {
            String inputLine;
            try {
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    // Process the line here
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}