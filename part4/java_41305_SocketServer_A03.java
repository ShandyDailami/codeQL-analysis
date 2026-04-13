import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_41305_SocketServer_A03 {

    public static void main(String[] args) {
        boolean isSecureServer = true;
        int port = 1234; // The port to listen to

        try {
            ServerSocket serverSocket = null;

            if (isSecureServer) {
                serverSocket = createSecureServerSocket(port);
            } else {
                serverSocket = new ServerSocket(port);
            }

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());

                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted secure connection from " + sslSocket.getRemoteSocketAddress());

                // Handle the client communication with the server
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ServerSocket createSecureServerSocket(int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = (ServerSocket) SSLServerSocket.create(port, null);
            serverSocket.setReuseAddress(true);
            return serverSocket;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}