import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07296_SocketServer_A08 {
    private static final String PASSWORD = "password"; // replace with your password
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        System.out.println("Server is running...");
        try {
            SSLServerSocket sslServerSocket = createSSLServerSocket();
            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Client connected");
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SSLServerSocket createSSLServerSocket() throws IOException {
        SSLServerSocket serverSocket = null;
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new InsecureTrustManager()}, null);
        serverSocket = (SSLServerSocket) sslContext.getServerSocketFactory().createServerSocket(8080);
        serverSocket.setNeedClientAuth(true);
        return serverSocket;
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_07296_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();
                if (sslSocket.getNeedClientAuth() == SSLSocket.FILTERED) {
                    sslSocket.close();
                    return;
                }
                // do something with the socket
                // e.g., read from the socket, write to the socket, or handle authentication
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class InsecureTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
            // do nothing
        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
            // do nothing
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}