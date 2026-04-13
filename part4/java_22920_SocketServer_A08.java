import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_22920_SocketServer_A08 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] {new TrustAllCertsTrustManager()}, null);
            serverSocket.setSSLContext(sslContext);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected");
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                PrintWriter out = new PrintWriter(outputStream, true);
                String userInput;
                while ((userInput = in.readLine()) != null) {
                    System.out.println("Received: " + userInput);
                    out.println("Hello, Client!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class TrustAllCertsTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(X509Certificate[] certs) {
            return true;
        }

        public void validateCertificate(X509Certificate cert) throws CertificateException {
            return;
        }
    }
}