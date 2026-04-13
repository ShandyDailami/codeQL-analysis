import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41992_SocketServer_A03 {

    private static final SSLServerSocket SERVER_SOCKET;

    static {
        SSLServerSocket srvSocket = null;
        try {
            SSLServerSocketFactory srvSockFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketFactory();
            srvSocket = (SSLServerSocket) srvSockFactory.createServerSocket(8080);
            srvSocket.setNeedClientAuth(true);
            srvSocket.setEnabledProtocols(new String[] {"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});

            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, new TrustManager[] { new TrustAllCertificatesTrustManager() }, new java.security.SecureRandom());
            srvSocket.setSSLSocketFactory(sslContext.getSocketFactory());

            SERVER_SOCKET = srvSocket;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        Socket clientSocket = SERVER_SOCKET.accept();
                        new SecureSocketServerHandler(clientSocket).start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static class SecureSocketServerHandler extends Thread {
        private Socket socket;

        public java_41992_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();
                // Here you can send, receive data
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class TrustAllCertificatesTrustManager implements X509TrustManager {

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public boolean isServerTrusted(X509Certificate[] chain) {
            return true;
        }

        public boolean isClientTrusted(X509Certificate[] chain) {
            return true;
        }

        public void validateCertificate(X509Certificate cert) throws CertificateException {
            return;
        }
    }
}