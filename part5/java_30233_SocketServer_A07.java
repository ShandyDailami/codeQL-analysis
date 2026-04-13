import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.net.InetAddress;
import java.io.*;

public class java_30233_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080,
                1000000, InetAddress.getByName("127.0.0.1"), null);
        sslServerSocket.setNeedClientAuth(true);
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.setNeedClientAuth(true);

        OutputStream out = sslSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);
        writer.println("Hello World!");
    }
}