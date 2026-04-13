import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class java_18424_SocketServer_A07 {

    public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        // Create a SSL ServerSocket with a trust store
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStorePath("path_to_keystore");
        sslServerSocketFactory.setKeyStorePassword("password");
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        // Create a SSL ServerSocket for non-Secure connections
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = null;
            try {
                // Accept incoming connection for secure connection
                socket = sslServerSocket.accept();
                System.out.println("Connected to " + socket.getRemoteSocketAddress());
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            // Handle the connection here
            new Handler(socket).start();
        }
    }
}