import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_06918_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);
        sslServerSocket.setEnabledProtocols(new String[] {"TLSv1.2"});

        Socket socket = sslServerSocket.accept();
        InetAddress clientAddress = socket.getInetAddress();

        System.out.println("Client: " + clientAddress.getHostAddress() + " connected");

        OutputStream outputStream = socket.getOutputStream();
        String response = "Hello, Client!";
        outputStream.write(response.getBytes());
        socket.close();
    }
}