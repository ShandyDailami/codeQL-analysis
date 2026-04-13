import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_02547_SocketServer_A07 {
    private final int port;
    private final ExecutorService pool;
    private boolean ssl = false;

    public java_02547_SocketServer_A07(int port) {
        this.port = port;
        pool = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        ServerSocket socket;
        if (ssl) {
            socket = (SSLServerSocket) new SSLServerSocket(port);
        } else {
            socket = new ServerSocket(port);
        }

        while (true) {
            final Socket connection = socket.accept();
            pool.execute(new Runnable() {
                public void run() {
                    try {
                        process(connection);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void process(Socket connection) throws IOException {
        // Implement authentication here
        // For simplicity, let's check if the client is connected
        if (connection.getInetAddress().equals(InetAddress.getByName("localhost"))) {
            connection.close();
            return;
        }

        connection.close();
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(12345);
        server.ssl = true; // Enable SSL
        server.start();
    }
}