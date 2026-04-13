import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_29275_SocketServer_A03 {

    private static final String SSL_SERVER_KEYSTORE = "server.jks";
    private static final String SSL_SERVER_KEYSTORE_PASSWORD = "password";
    private static final String SSL_CLIENT_KEYSTORE = "client.jks";
    private static final String SSL_CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SSL_TRUSTSTORE = "truststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "password";
    private static final String SSL_CIPHER_SUITE = "TLS_RSA";

    public static void main(String[] args) throws Exception {

        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocket.factory().newServerSocketFactory(
                            new SSLServerSocketFactory(
                                    new KeyStore(SSL_SERVER_KEYSTORE, SSL_SERVER_KEYSTORE_PASSWORD,
                                            SSL_TRUSTSTORE, SSL_TRUSTSTORE_PASSWORD, new SSLCertificateReader()),
                                    SSL_CIPHER_SUITE, SSL_CIPHER_SUITE, new DefaultSSLServerCipherSocketFactory(SSL_CIPHER_SUITE)),
                            61000, 128, true, false);
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(61000);
            serverSocket.setEnabled(true);

            System.out.println("Server is listening on port " + serverSocket.getLocalPort());
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                new SSLSocketReaderThread(clientSocket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static class SSLSocketReaderThread extends Thread {
        private final Socket socket;
        private final BufferedReader reader;
        private final PrintWriter writer;

        public java_29275_SocketServer_A03(Socket socket) {
            this.socket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);
                    // handle the request here, for example, respond with "OK"
                    writer.println("OK");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}