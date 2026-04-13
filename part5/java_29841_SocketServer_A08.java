import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.concurrent.*;

public class java_29841_SocketServer_A08 {
    private static final int PORT = 8888;
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuthentication(true);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());

            SSLServerSocket socket = (SSLServerSocket) sslServerSocket;
            socket.setSoTimeout(60000);
            socket.setReceiveBufferSize(1024 * 1024);
            socket.setSendBufferSize(1024 * 1024);

            while (true) {
                Socket clientSocket = socket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());
                Handler handler = new Handler(clientSocket, sslContext);
                executorService.execute(handler);
            }
        } finally {
            executorService.shutdown();
            sslServerSocket.close();
        }
    }

    static class Handler implements Runnable {
        private Socket socket;
        private SSLContext sslContext;

        public java_29841_SocketServer_A08(Socket socket, SSLContext sslContext) {
            this.socket = socket;
            this.sslContext = sslContext;
        }

        @Override
        public void run() {
            try {
                SSLServerSocket serverSocket = (SSLServerSocket) socket.getSocket();
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                InputStream inputStream = clientSocket.getInputStream();

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    byte[] receivedData = new byte[bytesRead];
                    System.arraycopy(buffer, 0, receivedData, 0, bytesRead);
                    int checkSum = checksum(receivedData);

                    // Verify integrity of received data with checksum
                    if (checkSum != -1) {
                        System.out.println("Integrity failure. Received data has invalid checksum.");
                        clientSocket.close();
                        serverSocket.close();
                        return;
                    }

                    // Process received data...
                }

                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private int checksum(byte[] data) {
            int sum = 0;
            for (byte b : data) {
                sum += b;
            }
            return sum;
        }
    }

    static class TrustAnyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException { }
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException { }
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}