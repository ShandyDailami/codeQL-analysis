import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_34106_SocketServer_A03 {
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "yourkeystorepassword";
    private static final String KEY_PASSWORD = "yourkeypassword";
    private static final SSLServerSocketFactory sslServerSocketFactory =
        (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

    public static void main(String[] args) throws IOException {
        runServer(10000); // port 10000
    }

    public static void runServer(int port) throws IOException {
        SSLServerSocket serverSocket = null;

        try {
            // Initialize server socket with SSL
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            serverSocket.setNeedClientAuth(true);

            // Load the server's certificate and private key
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContextBuilder
                .create()
                .loadKeyMaterial(KEYSTORE_LOCATION, KEY_PASSWORD.toCharArray())
                .build();

            // Set the SSLContext for the server socket
            serverSocket.setSSLContext(sslContext);

            while (true) {
                Socket socket = serverSocket.accept();
                handleRequest(socket);
            }
        } finally {
            serverSocket.close();
        }
    }

    public static void handleRequest(Socket socket) throws IOException {
        SSLSocket sslSocket = (SSLSocket) socket;

        InputStream inputStream = sslSocket.getInputStream();
        OutputStream outputStream = sslSocket.getOutputStream();

        // Handle the input and output here
    }
}