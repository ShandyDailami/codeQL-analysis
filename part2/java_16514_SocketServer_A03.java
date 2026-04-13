import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_16514_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            ServerSocket sslServerSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(12345, 50000, InetAddress.getByName("localhost"));

            while (true) {
                Socket sslSocket = sslServerSocket.accept();
                System.out.println("Accepted new connection from " + sslSocket.getRemoteSocketAddress());
                // Handle the new connection here
            }
        } catch (Exception ex) {
            Logger.getLogger(SecureSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}