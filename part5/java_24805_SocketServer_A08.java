import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_24805_SocketServer_A08 {

    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        String keyStorePath = "path_to_your_keystore.jks"; // replace with your keystore path
        String keyStorePassword = "your_keystore_password"; // replace with your keystore password

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // set up keystore
            serverSocket.setKeyStore(KeyStore.getInstance("JKS"), keyStorePassword.toCharArray());
            serverSocket.setNeedClientAuth(true);
            serverSocket.setKeystorePassword(keyStorePassword.toCharArray());

            while (true) {
                Socket socket = serverSocket.accept();
                LOGGER.log(Level.INFO, "New client connected: {0}", socket.getRemoteSocketAddress());
                new SocketHandler(socket).start();
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private static class SocketHandler extends Thread {
        private Socket socket;

        public java_24805_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle client socket here...
        }
    }
}