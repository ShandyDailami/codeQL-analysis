import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_03980_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5000, 10000, InetAddress.getByName("localhost"), null, null);

            serverSocket.setNeedClientAuth(true);

            // Set the key and trust store.
            serverSocket.setKeyStore(getKeyStore());
            serverSocket.setTrustStore(getTrustStore());

            logger.info("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                new HandlerThread(socket).start();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error accepting connection", ex);
       
        }
    }

    // Implementation of HandlerThread, which is responsible for handling the client connection
    private static class HandlerThread extends Thread {
        private final Socket socket;

        HandlerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle connection
        }
    }

    // Implementation of getting the key store and trust store
    private static javax.net.ssl.KeyStore getKeyStore() {
        try {
            return javax.net.ssl.keystore.KeyStore.getInstance("JKS");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to get keystore", ex);
            return null;
        }
    }

    private static javax.net.ssl.TrustStore getTrustStore() {
        try {
            return javax.net.ssl.keystore.TrustStore.getInstance("JKS");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to get truststore", ex);
            return null;
        }
    }
}