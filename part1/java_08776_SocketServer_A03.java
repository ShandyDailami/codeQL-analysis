import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_08776_SocketServer_A03 {

    private ExecutorService execService;
    private ServerSocket socket;

    public java_08776_SocketServer_A03(int port) throws IOException {
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
        sslServerSocket.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new InsecureTrustManager() }, new java.security.SecureRandom());
        sslServerSocket.setSSLContext(sslContext);
        socket = sslServerSocket;
        execService = Executors.newCachedThreadPool();
    }

    public void startServer() throws IOException {
        System.out.println("Server started on port " + socket.getLocalPort() + " with protocol " + socket.getProtocol());
        while (true) {
            Socket clientSocket = socket.accept();
            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
            execService.execute(new ClientHandler(clientSocket));
        }
    }

    public void stopServer() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        execService.shutdown();
    }

    public static void main(String[] args) throws IOException {
        new SecureServer(8080).startServer();
    }

    private class ClientHandler implements Runnable {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_08776_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        private void close() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class InsecureTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            // Do nothing
        }

        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            // Do nothing
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}