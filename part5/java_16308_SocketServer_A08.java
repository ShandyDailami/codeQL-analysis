import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class java_16308_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setEnabledSSLRoots("src/ssl/truststore.jks");
            sslServerSocket.setNeedClientAuth(true);
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            String response = "Hello, World!";
            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();
            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}