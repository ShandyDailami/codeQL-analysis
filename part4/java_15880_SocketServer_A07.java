import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_15880_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            sslSocket = (SSLSocket) sslServerSocket.accept();

            SSLInputStream sslIn = new SSLInputStream(sslSocket.getInputStream());
            SSLOutputStream sslOut = new SSLOutputStream(sslSocket.getOutputStream());

            sslOut.write("HTTP/1.1 200 OK\r\n".getBytes());
            sslOut.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
            sslOut.write("\r\n".getBytes());

            sslOut.flush();

            byte[] buffer = new byte[1024];
            int length;
            while ((length = sslIn.read(buffer)) != -1) {
                sslOut.write(buffer, 0, length);
            }

            sslSocket.close();
            sslServerSocket.close();

        } catch (SSLException e) {
            e.printStackTrace();
        }
    }
}