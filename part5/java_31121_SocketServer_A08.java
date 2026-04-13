import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_31121_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketChannel sslServerSocketChannel = SSLServerSocketChannel.open(new InetSocketAddress(8080));
            sslServerSocketChannel.bind();
            sslServerSocketChannel.listen(5);
            sslServerSocket = (SSLServerSocket) sslServerSocketChannel.accept();
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            InputStream inputStream = sslSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
           
            }
            sslSocket.close();
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }
}