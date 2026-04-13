import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_13789_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketChannel sslServerSocketChannel = SSLServerSocketChannel.open();
            sslServerSocket = (SSLServerSocket) sslServerSocketChannel.socket();
            sslServerSocket.bind(new InetSocketAddress(8000));
            sslServerSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, new TrustManager[]{new TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }});

            sslServerSocket.setSSLEngine(sslContext.getServerSSLEngine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            SSLSocket client = sslServerSocket.accept();
            System.out.println("Accepted connection from " + client.getRemoteSocketAddress());

            OutputStream outputStream = client.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("Hello, client!");
            writer.flush();

            client.close();
        }
    }
}