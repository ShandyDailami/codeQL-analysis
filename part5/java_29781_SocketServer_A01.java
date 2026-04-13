import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_29781_SocketServer_A01 {
    private static final String PASSWORD = "secure_password"; // Password for SSL
    private static final int PORT = 12345; // Port to listen on

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = null;
        SSLServerSocket sslServerSocket = null;
        try {
            // Set up the server
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            sslServerSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustedCertsTrustManager() }, null);
            serverSocketChannel = ServerSocketChannel.open(PORT);
            serverSocketChannel.bind();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().setReuseAddress(true);

            // Set up the SSLContext
            SSLServerSocketChannel sslServerSocketChannel = (SSLServerSocketChannel) serverSocketChannel.accept();
            sslServerSocketChannel.configureBlocking(false);
            sslServerSocketChannel.bind();

            // Start the SSL connection
            SSLSocket socket = (SSLSocket) sslServerSocketChannel.accept();
            socket.startHandshake();
            SSLCertificate cert = socket.getLocalCertificate();
            System.out.println("Connected to: " + cert.getSubjectDN().getName());

            // Read from client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Received: " + line);
                writer.write(("Hello, client, you said: " + line).getBytes());
                writer.newLine();
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocketChannel != null) {
                sslServerSocketChannel.close();
            }
            if (serverSocketChannel != null) {
                serverSocketChannel.close();
            }
        }
    }

    static class TrustedCertsTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}