import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_40164_SocketServer_A03 {

    private static final int PORT = 8888;
    private static final String CLIENT_IDENTIFIER = "SSLServer";

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT, 100, InetAddress.getByName("localhost"), CLIENT_IDENTIFIER);
        sslServerSocket.setNeedClientAuth(true);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clientSocket = sslServerSocket.accept();
            pool.execute(new SecureClientHandler(clientSocket));
        }
    }

    static class SecureClientHandler implements Runnable {
        private Socket clientSocket;

        public java_40164_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here.
            // This can involve reading from and writing to the socket.
        }
    }
}