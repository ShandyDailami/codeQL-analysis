import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_01525_SocketServer_A08 {

    private final int port;
    private final ExecutorService executorService;

    public java_01525_SocketServer_A08(int port) {
        this.port = port;
        int cores = Runtime.getRuntime().availableProcessors();
        this.executorService = Executors.newFixedThreadPool(cores * 2);
    }

    public void start() {
        Runnable worker = new SecureSocketServerWorker(this);
        new Thread(worker).start();
    }

    private class SecureSocketServerWorker implements Runnable {

        private final SecureSocketServer server;

        public java_01525_SocketServer_A08(SecureSocketServer server) {
            this.server = server;
        }

        @Override
        public void run() {
            try (SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(port)) {
                sslServerSocket.setNeedClientAuth(true);
                sslServerSocket.setEnabledCipherSuites(new String[] {"TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256"});
                sslServerSocket.setKeyStore(null, null, null); // self-signed

                while (true) {
                    SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                    clientSocket.setNeedClientAuth(true);

                    InetAddress ip = clientSocket.getInetAddress();
                    System.out.println("Accepted connection from " + ip.getHostAddress());

                    executorService.execute(new SocketHandler(clientSocket));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class SocketHandler implements Runnable {

        private final Socket socket;

        public java_01525_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle socket communication here
        }
    }
}