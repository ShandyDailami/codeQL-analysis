import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_39487_SocketServer_A03 {

    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocketChannel.accept();
        sslServerSocket.setNeedClientAuthentication(true);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, new java.security.SecureRandom());
        SSLServerSocket socket = (SSLServerSocket) sslContext.getServerSocket(sslServerSocket);
        socket.setNeedClientAuthentication(true);

        while (true) {
            Socket clientSocket = socket.accept();
            executor.execute(new SocketHandler(clientSocket));
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;
        private final BufferedReader in;
        private final PrintWriter out;

        public java_39487_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println(message);
            }
        }
    }

    private static class TrustAllCerts implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}