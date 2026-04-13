import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_32014_SocketServer_A07 {
    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        runServer(8080);
    }

    private static void runServer(int port) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port, 1000, InetAddress.getByName("localhost"));

            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

            while (true) {
                Socket clientSocket = sslServerSocket.accept();
                logger.log(Level.INFO, "Accepted connection from: " + clientSocket.getInetAddress().getHostAddress());

                new HandlerThread(clientSocket).start();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error accepting client connection", ex);
        }
    }

    private static class HandlerThread extends Thread {
        private Socket socket;

        public java_32014_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client connection here
            // ...
        }
    }
}