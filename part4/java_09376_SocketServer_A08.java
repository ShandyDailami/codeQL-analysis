import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_09376_SocketServer_A08 {

    private static final int PORT = 9999;

    public static void main(String[] args) throws Exception {
        System.out.println("Starting server on port " + PORT);

        // Create a SSLServerSocketFactory using a keystore and an entry.
        SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory();

        ServerSocket serverSocket = null;
        if (sslServerSocketFactory != null) {
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        } else {
            serverSocket = new ServerSocket(PORT);
        }

        while (true) {
            SSLSocket sslSocket = (SSLSocket) serverSocket.accept();

            // Enable server-side SSL.
            sslSocket.setNeedClientAuthentication(true);
            System.out.println("Client connected");

            // Handle communication with client
            handleClient(sslSocket);

            sslSocket.close();
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory() {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(SecureSocketServer.class.getResourceAsStream("/server.jks"), "password".toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            return sslServerSocketFactory;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void handleClient(SSLSocket sslSocket) {
        // Create a new thread for handling each client's request.
        new HandlerThread(sslSocket).start();
    }

    private static class HandlerThread extends Thread {
        private final SSLSocket sslSocket;

        public java_09376_SocketServer_A08(SSLSocket sslSocket) {
            this.sslSocket = sslSocket;
        }

        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
                 java.util.Scanner in = new java.util.Scanner(sslSocket.getInputStream())) {

                // Read and print client's input
                while (in.hasNextLine()) {
                    System.out.println("Received: " + in.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}