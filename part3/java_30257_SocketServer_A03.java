import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.cert.CertificateException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServletException;

public class java_30257_SocketServer_A03 {

    private static final String SSL_PORT = "8443"; // SSL port
    private static final String SERVER_PORT = "8080"; // Standard port

    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();

        try (SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(Integer.parseInt(SSL_PORT))) {
            System.out.println("SSL server is listening on port " + SSL_PORT);

            while (true) {
                final SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("New client connected");
                executor.execute(new ClientHandler(sslSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {

        private final SSLSocket sslSocket;

        ClientHandler(SSLSocket sslSocket) {
            this.sslSocket = sslSocket;
        }

        @Override
        public void run() {
            try {
                // Receive data from the client and send it back
                OutputStream outputStream = sslSocket.getOutputStream();
                while (true) {
                    byte[] buffer = new byte[1024];
                    int length = sslSocket.getInputStream().read(buffer);
                    if (length == -1) {
                        sslSocket.close();
                        return;
                    }
                    outputStream.write(buffer, 0, length);
                    outputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}