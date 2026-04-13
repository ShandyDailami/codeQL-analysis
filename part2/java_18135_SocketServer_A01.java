import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_18135_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                System.out.println("Waiting for client on port: " + sslServerSocket.getPort());
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Accepted connection from: " + sslSocket.getRemoteSocketAddress());

                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();

                byte[] bytes = new byte[1024];
                int length = inputStream.read(bytes);
                if (length < 0) {
                    break;
                }

                String message = new String(bytes, 0, length);
                System.out.println("Received message: " + message);

                String response = "Hello, Client!";
                outputStream.write(response.getBytes());
                outputStream.flush();

                sslSocket.close();
            }

            sslServerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}