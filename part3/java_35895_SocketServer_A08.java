import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_35895_SocketServer_A08 {
    private static final int PORT = 8888;
    private static ExecutorService executorService;

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            sslServerSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAllCertsTrustManager() }, null);
            sslServerSocket.setSSLContext(sslContext);

            executorService = Executors.newCachedThreadPool();

            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Client connected");
                executorService.execute(new SocketHandler(socket));
            }
        } finally {
            sslServerSocket.close();
            executorService.shutdown();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_35895_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                DataOutputStream writer = new DataOutputStream(outputStream);

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);
                    writer.writeBytes("OK\n");
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}