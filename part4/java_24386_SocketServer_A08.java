import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_24386_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket sock = null;
        SSLServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create SSLServerSocket using SSL/TLS port
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // Create server socket
            sock = new ServerSocket();
            sock.bind(new InetSocketAddress(8080));
            System.out.println("Server is listening on port 8080");

            while (true) {
                // Wait for a client connection
                socket = serverSocket.accept();

                System.out.println("Client accepted: " + socket.getInetAddress().getHostAddress());

                // Handshake
                SSLSocket sslSock = (SSLSocket) socket.getSocket();
                sslSock.startHandshake();

                // Now you can use sslSock to send/receive data securely
                // ...
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (sock != null) sock.close();
        }
    }
}