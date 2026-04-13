import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_04498_SocketServer_A03 {

    private final int port;

    public java_04498_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        try {
            // Create a SSLServerSocket for listening
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            sslServerSocket.setNeedClientAuth(true); // Enable client authentication

            // Accept client connections
            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Accepted connection from: " + socket.getRemoteSocketAddress());
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler extends Thread {
        private final Socket socket;

        public java_04498_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client connection here
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(8080).start();
    }
}