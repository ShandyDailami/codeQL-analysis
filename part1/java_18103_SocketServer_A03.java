import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_18103_SocketServer_A03 {

    private static SSLServerSocket serverSocket;
    private static Socket clientSocket;
    private static SSLContext sslContext;

    public static void main(String[] args) {
        init();

        try {
            while (true) {
                clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) clientSocket.accept();
                sslSocket.setNeedClientAuth(true);
                sslSocket.setUseClientMode(true);
                sslContext.init(null, new X509Certificate[] {sslSocket.getRemoteCertificate()}, null, new java.security.SecureRandom());
                sslSocket.setSSLSocket(sslSocket);
                sslSocket.startHandshake();
                SSLSession session = sslSocket.getSession();
                System.out.println("Client: " + session.getRemoteSocketAddress() + " Connected");

                // Send a response back to the client
                OutputStream out = sslSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello Client, You are connected to the Socket Server!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void init() {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setEndpointIdentificationAlgorithm(SSLSocketFactory.DEFAULT_ENDPOINT_IDENTIFICATION_ALGORITHM);

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream("client.jks"), "password".toCharArray());

        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, null, null);
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
    }
}