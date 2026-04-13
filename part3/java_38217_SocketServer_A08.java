import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_38217_SocketServer_A08 {

    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());

    private static final int PORT = 4445;

    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    public void start() {
        Runnable worker = new Worker();

        // Using SSL to encrypt the communication
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                Socket socket = sslServerSocket.accept();
                LOGGER.log(Level.INFO, "Accepted connection from: {0}", socket.getInetAddress());
                pool.submit(worker);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Failed to start the server", e);
        } finally {
            pool.shutdown();
        }
    }

    private static class Worker implements Runnable {
        @Override
        public void run() {
            // Here you can write the code related to A08_IntegrityFailure
        }
    }

    public static void main(String[] args) {
        new SocketServer().start();
    }
}