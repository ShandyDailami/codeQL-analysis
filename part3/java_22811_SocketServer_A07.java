import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_22811_SocketServer_A07 {

    private final static int PORT = 9090;
    private final static String PASSWORD = "password"; // for basic authentication

    public static void main(String[] args) throws IOException {
        System.out.println("Server listening on port: " + PORT);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ServerSocket socket = null;
        if (PORT == 9090) {
            socket = new ServerSocket(PORT);
        } else {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            socket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            socket.setNeedClientAuth(true);
            socket.setPassword(PASSWORD.getBytes());
        }

        while (true) {
            Socket connection = socket.accept();
            System.out.println("Accepted new connection from: " + connection.getRemoteSocketAddress());
            executorService.execute(new ClientHandler(connection));
        }
    }

    private static class ClientHandler implements Runnable {

        private final Socket socket;

        public java_22811_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle client connection here
        }
    }
}