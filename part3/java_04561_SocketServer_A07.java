import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_04561_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        sslServerSocket.setReuseAddress(true);
        sslServerSocket.bind(InetAddress.getByName("localhost"), PORT);

        System.out.println("Server started. Listening on port " + PORT + "...");

        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());
            executor.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        Socket socket;

        public java_04561_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the socket connection here
        }
    }
}