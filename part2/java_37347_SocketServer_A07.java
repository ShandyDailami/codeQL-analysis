import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_37347_SocketServer_A07 {

    private static final String CLIENT_KEY_STORE = "client.keystore";
    private static final String CLIENT_KEY_STORE_PASSWORD = "password";
    private static final String SERVER_KEY_STORE = "server.keystore";
    private static final String SERVER_KEY_STORE_PASSWORD = "password";
    private static final String ALTERNATE_KEY_PASSWORD = "password";

    public static void main(String[] args) throws IOException, CertificateException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStorePassword(CLIENT_KEY_STORE_PASSWORD);

        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080);
        serverSocket.setReuseAddress(true);

        while (true) {
            SSLSocket client = (SSLSocket) serverSocket.accept();
            client.setReuseAddress(true);

            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            sslSocketFactory.setKeyStorePassword(SERVER_KEY_STORE_PASSWORD);

            SocketServerThread socketServerThread = new SocketServerThread((SSLSocket) sslSocketFactory.createSocket(client, "localhost", 8081, true));
            socketServerThread.start();
        }
    }

    private static class SocketServerThread extends Thread {

        private final SSLSocket socket;

        public java_37347_SocketServer_A07(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle requests and responses here
        }
    }
}