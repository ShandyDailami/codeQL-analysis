import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_27862_SocketServer_A03 {

    private static final String SSL_PORT = "5000";
    private static final String INSECURE_SERVER_ADDRESS = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(Integer.parseInt(SSL_PORT), null, null, InetAddress.getByName(INSECURE_SERVER_ADDRESS));

            while (true) {
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");
                // Here you would create a new thread for each client to handle their request
            }
        } finally {
            serverSocket.close();
        }
    }
}