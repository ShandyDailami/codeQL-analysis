import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_01856_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        // Use port 8080 for HTTP server and 8081 for SSL server
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8081);

        while (true) {
            SSLSocket socket = (SSLSocket) serverSocket.accept();
            System.out.println("New client connected");

            // Perform security-sensitive operations related to A08_IntegrityFailure
            // Here, we'll just print out the socket details for verification
            System.out.println("Client IP: " + socket.getInetAddress().getHostAddress());
            System.out.println("Client Port: " + socket.getPort());
        }
    }
}