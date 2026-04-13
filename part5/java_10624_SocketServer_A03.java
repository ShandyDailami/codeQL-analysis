import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_10624_SocketServer_A03 {

    private static final int PORT = 8080;
    private static final int MAX_THREADS = 10;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket sock = sslServerSocket.accept();
                System.out.println("Accepted connection from: " + sock.getRemoteSocketAddress());

                executor.execute(new SocketHandler(sock));
            }
        } finally {
            sslServerSocket.close();
            executor.shutdown();
        }
    }

    private static class SocketHandler implements Runnable {
        private Socket sock;

        public java_10624_SocketServer_A03(Socket sock) {
            this.sock = sock;
        }

        @Override
        public void run() {
            try {
                // Here you could implement your input/output operations, e.g.
                // sock.getInputStream().read() and sock.getOutputStream().write()

                // Example: Reading from the input stream and writing to the output stream
                byte[] bytes = new byte[1000];
                int length = sock.getInputStream().read(bytes);
                if (length != -1) {
                    sock.getOutputStream().write(bytes, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}