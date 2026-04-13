import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_06236_SocketServer_A03 {

    public static void main(String[] args) throws Exception {

        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new X509Certificate[] {}, null);
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                socket = sslServerSocket.accept();

                SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);

                BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(sslSocket.getOutputStream());

                // write response headers to the client
                writer.write("HTTP/1.1 200 OK\r\n".getBytes());
                writer.write("Content-Type: text/html\r\n".getBytes());
                writer.write("\r\n".getBytes());

                // send response body
                writer.write("<html><body><h1>Hello, World!</h1></body></html>".getBytes());

                writer.flush();
                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}