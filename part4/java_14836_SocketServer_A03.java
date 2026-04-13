import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.concurrent.*;

public class java_14836_SocketServer_A03 {
    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_14836_SocketServer_A03(int port) throws IOException {
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
        sslServerSocket.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] { new TrustManagerSSL() }, new java.security.SecureRandom());
        sslServerSocket.setSSLSocketFactory(sslContext.getSocketFactory());
        serverSocket = sslServerSocket;
        executor = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            executor.execute(new SocketHandler(socket));
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
        executor.shutdown();
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_14836_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}