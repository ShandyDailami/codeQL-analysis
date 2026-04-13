import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class java_10956_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        serverSocket.setNeedClientAuth(true);
        while (true) {
            SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
            sslSocket.setNeedClientAuth(true);
            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            // read request
            byte[] bytes = new byte[1024];
            int bytesRead = inputStream.read(bytes);
            if (bytesRead <= 0) {
                continue;
            }

            // write response
            String response = "Hello, client!";
            outputStream.write(response.getBytes());
            sslSocket.close();
        }
    }
}