import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33970_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);

        Socket socket = sslServerSocket.accept();
        SSLSocket sslSocket = (SSLSocket) socket;

        System.out.println("Client connected!");

        InputStream inputStream = sslSocket.getInputStream();
        OutputStream outputStream = sslSocket.getOutputStream();

        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        String message = new String(bytes);
        System.out.println("Message from client: " + message);

        String response = "Hello, client!";
        outputStream.write(response.getBytes());

        sslSocket.close();
        sslServerSocket.close();
    }
}