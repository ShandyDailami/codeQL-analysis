import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_12892_SocketServer_A08 {

    private static final String CLIENT_CERT_PATH = "/path/to/client.cert";
    private static final String SERVER_KEY_PATH = "/path/to/server.key";
    private static final String SERVER_CERT_PATH = "/path/to/server.cert";

    public static void main(String[] args) throws IOException {

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234, null, InetAddress.getByName("localhost"));

        sslServerSocket.setNeedClientAuth(true);
        sslServerSocket.setCertificateExtensions({"SSL-Client-Cert"});

        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

        sslSocket.setNeedClientAuth(true);
        sslSocket.setCertificateExtensions({"SSL-Client-Cert"});

        InputStream inputStream = sslSocket.getInputStream();
        OutputStream outputStream = sslSocket.getOutputStream();

        // Send some data
        outputStream.write("Hello, Client!".getBytes());
        outputStream.close();

        // Receive the data
        byte[] b = new byte[1024];
        int length = inputStream.read(b);
        System.out.println("Server received: " + new String(b, 0, length));

        sslSocket.close();
        sslServerSocket.close();
    }
}