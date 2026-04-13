import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_15287_SocketServer_A01 {
    private static final String SSL_KEYSTORE = "path_to_your_keystore";
    private static final String SSL_KEYSTORE_PASSWORD = "password";
    private static final String SSL_TRUSTSTORE = "path_to_your_truststore";
    private static final String SSL_TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) {
        System.out.println("Starting server...");

        // Create server socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = (SSL_ENABLED) ? createSSLServerSocket(serverSocket) : createServerSocket(serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Create SSL socket
                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getChannel().getFactory());
                sslSocket.setNeedClientAuthentication(true);

                // Setup SSL context
                sslSocket.setUseClientMode(true);
                sslSocket.setNeedServerMode(true);

                // Setup SSL keys and trust store
                sslSocket.setSSLSocketFactory(createSSLServerSocketFactory(sslSocket));

                // Send welcome message
                sslSocket.setSoWriteTimeout(10000);
                sslSocket.setSoTimeout(10000);
                sslSocket.setTcpNoDelay(true);

                sslSocket.connect();
                sslSocket.write(("Welcome to SSL Socket Server!!").getBytes());

                // Read and print response
                byte[] bytes = new byte[1024];
                int readBytes = sslSocket.read(bytes);
                System.out.println("Server response: " + new String(bytes, 0, readBytes));

                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static ServerSocket createServerSocket(ServerSocket serverSocket) throws IOException {
        return new SSLServerSocket(createSSLServerSocketFactory(serverSocket));
    }

    private static SSLServerSocketFactory createSSLServerSocketFactory(ServerSocket serverSocket) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = SSLServerSocketFactory.create(serverSocket);
            sslServerSocketFactory.getDefaultCertificate(SSL_KEYSTORE, SSL_KEYSTORE_PASSWORD);
            sslServerSocketFactory.getDefaultCertificate(SSL_TRUSTSTORE, SSL_TRUSTSTORE_PASSWORD);
            return sslServerSocketFactory;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static ServerSocket createSSLServerSocket(ServerSocket serverSocket) throws IOException {
        return (SSL_ENABLED) ? new SSLServerSocket(serverSocket) : new ServerSocket();
    }
}