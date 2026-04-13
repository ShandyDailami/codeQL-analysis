import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_08590_SocketServer_A08 {
    private static final String SSL_PORT = "9999";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
            sslServerSocket.setNeedClientAuth(true);
            SSLContext sslContext = sslServerSocket.getSSLContext();

            //create SSLSocket
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
            sslSocket.setUseClientMode(true);

            //create BufferedReader and PrintWriter
            InputStream inputStream = sslSocket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            OutputStream outputStream = sslSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            //Send response
            printWriter.println("Hello, client!");
            printWriter.close();
            sslSocket.close();
            sslServerSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}