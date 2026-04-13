import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_28684_SocketServer_A03 {

    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    public void startServer(int port, String keyStorePath, String keyStorePassword) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port, 10000, InetAddress.getByName("localhost"));
            serverSocket.setNeedClientAuthentication(true);
            serverSocket.setEnabledCipherSuites(sslCipherSuites);
            serverSocket.setEnabledProtocols(sslProtocols);

            SSLCertificate certificate = new SSLCertificate(keyStorePath.getBytes(), keyStorePassword.getBytes());
            serverSocket.setNeedClientCertificate(true);
            serverSocket.setClientCertificate(certificate);

            while (true) {
                pool.execute(new SocketHandler(serverSocket.accept()));
            }
        } finally {
            serverSocket.close();
            pool.shutdown();
        }
    }

    private final String[] sslProtocols = {"SSLv3", "TLSv1", "TLSv1.1"};
    private final String[] sslCipherSuites = {"TLSv1", "TLSv1.1"};

    private class SocketHandler implements Runnable {

        private Socket socket;
        private PrintWriter writer;

        public java_28684_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                sslSocket.setNeedClientAuth(true);
                sslSocket.setEnabledCipherSuites(sslCipherSuites);
                sslSocket.setEnabledProtocols(sslProtocols);
                writer.println("Hello, client!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}