import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_31338_SocketServer_A03 {

    private static SSLServerSocket serverSocket;
    private static SSLSocket clientSocket;
    private static SSLContext context;

    public static void main(String[] args) {
        try {
            initializeServer();
            acceptClients();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private static void initializeServer() throws IOException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream("client.jks"), "password".toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(KeyStore.getDefaultType());
        trustManagerFactory.init(trustStore);

        SSLServerSocketFactory sslServerSocketFactory = new SSLServerSocketFactory(keyStore, trustManagerFactory);

        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
        serverSocket.setEnabledCertificateCertificateVerification(true);
    }

    private static void acceptClients() throws IOException {
        while (true) {
            clientSocket = serverSocket.accept();
            clientSocket.setEnabledCipherSuites(new String[] {"TLSv1", "TLSv1.1", "TLSv1.2"});
            context = SSLContext.getInstance("TLSv1.2");
            context.init(null, trustManagerFactory.getTrustManagers(), new java.security.SecureRandom());
            SSLSocketFactory sslSocketFactory = context.getSocketFactory();
            clientSocket = (SSLSocket) sslSocketFactory.createSocket(clientSocket.getInetAddress(), clientSocket.getPort());
            OutputStream out = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello, Client!");
        }
    }

    private static void closeResources() {
        try {
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}