import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_14803_SocketServer_A07 {
    private static final String CLIENT_IP = "127.0.0.1"; // Change this to the IP address you want to allow connections from

    public static void main(String[] args) throws Exception {
        SSLServerThread serverThread = new SSLServerThread();
        serverThread.start();
    }

    private static class SSLServerThread extends Thread {
        private final SSLServerSocket serverSocket;

        public java_14803_SocketServer_A07() {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443, null);
            serverSocket.setNeedClientAuth(true); // Enable client authentication
        }

        @Override
        public void run() {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());

                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                sslSocket.setNeedClientAuth(true); // Set this for client authentication

                // Perform SSL handshake and print the certificate
                sslSocket.handshake();
                X509Certificate cert = sslSocket.getSession().getPeerCertificate();
                System.out.println("Server certificate:\n" + cert.toString());

                // Continue with the rest of your code here...

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    socket.close();
                }
            }
        }
    }
}