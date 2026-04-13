import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36743_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);

        Socket socket = sslServerSocket.accept();
        System.out.println("Client accepted");

        SSLSocket sslSocket = (SSLSocket) socket;
        sslSocket.setNeedClientAuth(true);

        InputStream inputStream = sslSocket.getInputStream();
        OutputStream outputStream = sslSocket.getOutputStream();

        // Write your server logic here
        String serverResponse = "Hello, Client!";
        outputStream.write(serverResponse.getBytes());

        sslSocket.close();
    }
}