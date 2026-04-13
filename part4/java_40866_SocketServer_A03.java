import javax.net.ssl.*;
import java.net.*;
import java.io.*;

public class java_40866_SocketServer_A03 {
    private static final int PORT = 12345;
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        serverSocket.setNeedClientAuth(true);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] {new TrustAnyTrustManager()}, new java.security.SecureRandom());
        serverSocket.setSSLContext(sslContext);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received message: " + clientMessage);
                writer.println("Server says: " + clientMessage);
            }

            clientSocket.close();
        }
    }

    private static class TrustAnyTrustManager implements X509TrustManager {
        public boolean checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            return true;
        }

        public boolean checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            return true;
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }
}