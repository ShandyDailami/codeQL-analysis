import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_07445_SocketServer_A03 {
    private static final int PORT = 12345;
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER"; // Replace with your own value

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setEnabledCipherSuites(new String[]{"TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA"});

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new X509TrustManager() }, new java.security.SecureRandom());

            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                socket.setSoTimeout(10000);
                socket.setIdleTimeout(60000);
                SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

                String clientCert = sslSocket.getRemoteSocketAddress().toString();
                clientCert = clientCert.substring(clientCert.lastIndexOf("/") + 1);
                out.println("Received SSL certificate fingerprint: " + clientCert);

                executorService.execute(new WorkerThread(in, out, sslSocket));
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            executorService.shutdown();
        }
    }

    static class WorkerThread implements Runnable {
        private final BufferedReader in;
        private final PrintWriter out;
        private final SSLSocket sock;

        WorkerThread(BufferedReader in, PrintWriter out, SSLSocket sock) {
            this.in = in;
            this.out = out;
            this.sock = sock;
        }

        @Override
        public void run() {
            String received;
            try {
                received = in.readLine();
                out.println("Server: " + received);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}