import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_41346_SocketServer_A03 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444);
        serverSocket.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, null);
        serverSocket.setSSLContext(sslContext);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            SSLSocket sslSocket = (SSLSocket) clientSocket.getTransport();
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());
            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                out.write("Hello, client".getBytes());
                out.newLine();
                out.flush();
            }
            clientSocket.close();
        }
    }

    static class TrustAnyTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }

        public boolean isTrusted(X509Certificate[] chain) {
            return true;
        }

        public void invalidateCertificate(X509Certificate cert) {
        }
    }
}