import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_06050_SocketServer_A03 {

    private static SSLServerSocket serverSocket;
    private static SSLSocket clientSocket;
    private static SSLContext context;

    public static void main(String[] args) throws Exception {
        init();
        serve();
        close();
    }

    private static void init() throws Exception {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(new java.security.cert.CertificateRequest(null, null, null, null, null, null, tmf.getTrustManagers()));
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("keystore.jks"), "password".toCharArray());
        context = SSLContext.getInstance("TLS");
        context.init(keyStore, null, tmf.getTrustManagers(), null);
        serverSocket = (SSLServerSocket) context.getServerSocket(8080);
    }

    private static void serve() throws IOException {
        while (true) {
            clientSocket = serverSocket.accept();
            System.out.println("Connection accepted from: " + clientSocket.getRemoteSocketAddress());
            OutputStream out = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello, client!");
            clientSocket.close();
        }
    }

    private static void close() throws IOException {
        serverSocket.close();
        context.getServerSocket(8080).close();
    }
}