import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_14583_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, 1024, InetAddress.getByName("localhost"));

        sslServerSocket.setNeedClientAuth(true);

        Socket socket = sslServerSocket.accept();
        System.out.println("Client connected");

        socket.close();
        sslServerSocket.close();
    }
}