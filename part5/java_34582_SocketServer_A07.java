import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_34582_SocketServer_A07 {

    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_password";
    private static final String KEY_PASSWORD = "your_password";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        // Create a server socket
        ServerSocket serverSocket = null;
        if (args.length > 0 && args[0].equals("ssl")) {
            // Create an SSL server socket
            serverSocket = createSSLServerSocket(8080);
        } else {
            // Create a non-SSL server socket
            serverSocket = createNonSSLServerSocket(8080);
        }

        // Accept connections
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
            new ClientHandler(socket).start();
        }
    }

    private static ServerSocket createSSLServerSocket(int port) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        ServerSocketFactory sockFactory = (ServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sock = (SSLServerSocket) sockFactory.createServerSocket(port, 1024);
        sock.setNeedClientAuthentication(true);

        sock.setKeyStore(KEYSTORE_LOCATION, KEY_PASSWORD.toCharArray());
        sock.setCertificateExtensions(new String[] { "SSL-Client-Auth" });
        sock.setNeedClientCertificate(true);
        sock.setValidateClient(true);

        return sock;
    }

    private static ServerSocket createNonSSLServerSocket(int port) throws IOException {
        return new ServerSocket(port);
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_34582_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client connection and communication here
        }
    }
}