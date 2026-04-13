import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_34275_SocketServer_A07 {

    private static final String SSL_SERVER_KEYSTORE = "server.jks";
    private static final String SSL_SERVER_KEYSTORE_PASSWORD = "password";
    private static final String SSL_SERVER_TRUSTSTORE = "client.jks";
    private static final String SSL_SERVER_TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(SSL_SERVER_KEYSTORE), SSL_SERVER_KEYSTORE_PASSWORD.toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream(SSL_SERVER_TRUSTSTORE), SSL_SERVER_TRUSTSTORE_PASSWORD.toCharArray());

            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket;
            sslServerSocket.setKeyStore(keyStore);
            sslServerSocket.setTrustStore(trustStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, new String[] {SSL_SERVER_TRUSTSTORE}, new java.security.SecureRandom());
            sslServerSocket.setSSLEngine(sslContext.getSSLEngine());

            while (true) {
                Socket clientSocket = sslServerSocket.accept();
                System.out.println("Client connected.");

                SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
                sslSocket.setNeedClientAuth(true);

                OutputStream out = sslSocket.getOutputStream();
                out.write("HTTP/1.1 200 OK\r\n".getBytes());
                out.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
                out.write("\r\n".getBytes());
                out.write("Hello, client! This is the server side of an HTTPS connection.".getBytes());
                out.flush();

                sslSocket.close();
                System.out.println("Client disconnected.");
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}