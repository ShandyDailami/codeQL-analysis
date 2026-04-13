import java.io.IOException;
import java.net.InetSocketAddr;
import java.net.SocketException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_41387_SocketServer_A08 {

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(10000);
            InetSocketAddr socketAddress = new InetSocketAddr(10000);
            serverSocket.bind(socketAddress);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");

                SSLSocket sslSocket2 = (SSLSocket) sslSocket.accept();
                System.out.println("Another client connected");

                // Close connections and release resources
                sslSocket2.close();
                sslSocket.close();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}