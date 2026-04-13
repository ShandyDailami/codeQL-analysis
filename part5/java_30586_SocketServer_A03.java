import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_30586_SocketServer_A03 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
            serverSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new X509ExtendedKeyManager[] { new TrustManagerX509() }, new java.security.SecureRandom());

            while (true) {
                SSLSocket clientSocket = (SSLSocket) sslContext.getServerSocketFactory().createServerSocket(null, 100, null, false, serverSocket.getInetAddress()).accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    out.println("Server received: " + message);
                }

                out.close();
                in.close();
                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SSLException e) {
            e.printStackTrace();
        }
    }

    static class TrustManagerX509 implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException { }
        public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException { }
    }
}