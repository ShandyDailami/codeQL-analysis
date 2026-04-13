import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26001_SocketServer_A03 {
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuthentication(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new TrustAllCertsTrustManager()}, null);
            serverSocket.setSSLContext(sslContext);
            System.out.println("Waiting for client on port " + PORT + " ...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted from " + clientSocket.getRemoteSocketAddress());
                new SSLConnection(clientSocket).start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}

class SSLConnection extends Thread {
    private final Socket socket;

    public java_26001_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            SSLSocket sslSocket = (SSLSocket) socket.createSocket();
            sslSocket.startHandshake();
            // Now sslSocket is connected to the server and can be used to send and receive data
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class TrustAllCertsTrustManager implements X509TrustManager {
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[]{};
    }

    public boolean isTrusted(X509Certificate[] certs) {
        return true;
    }

    public void validateCertificate(X509Certificate cert) throws CertificateException {
        return;
    }
}