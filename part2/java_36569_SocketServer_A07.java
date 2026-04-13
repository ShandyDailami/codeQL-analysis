import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_36569_SocketServer_A07 {

    private final int port;
    private final String bindAddress;

    public java_36569_SocketServer_A07(int port, String bindAddress) {
        this.port = port;
        this.bindAddress = bindAddress;
    }

    public void run() {
        ServerSocketFactory socketFactory = (ServerSocketFactory) SSLServerSocketFactory.getDefault();
        try (ServerSocket serverSocket = (ServerSocket) socketFactory.createServerSocket(new InetSocketAddress(bindAddress, port), 50, 0)) {
            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socketFactory.createSocket(socket, socket.getInetAddress(), port, true);
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();
                if (sslSocket.getNeedClientAuth() == true && sslSocket.getSession() == null) {
                    System.out.println("Client not authenticated");
                    sslSocket.close();
                    continue;
                }
                System.out.println("Client authenticated");
                // Process the socket here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SecureServer(4444, "127.0.0.1").run();
    }
}