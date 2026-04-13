import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_06663_SocketServer_A03 {

    private static final int PORT = 8888;
    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setEnabledCertificateMatchSelector("SHA1AndSHA256MatchSelector");
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("TLSv1_2");
            sslContext.init(null, new TrustManager[] { new X509TrustManager() }, null);
            serverSocket.setSSLContext(sslContext);
            executor = Executors.newCachedThreadPool();
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executor.execute(new SocketHandler(clientSocket));
            }
        } finally {
            serverSocket.close();
            executor.shutdown();
        }
    }

    private static class SocketHandler implements Runnable {

        private Socket socket;

        public java_06663_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    outputStream.writeBytes("Message received\n");
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}