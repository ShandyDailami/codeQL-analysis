import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16275_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);
        sslServerSocket.setNeedClientAuthentication(true); // Require client to present certificate

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            System.out.println("Client connected");

            SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            System.out.println("Client connected");

            // Reading data from the client
            InputStream inputStream = clientSocket.getInputStream();
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                if (bytesRead == -1) break;
                System.out.println("Received: " + new String(buffer, 0, bytesRead));
            }

            // Writing data to the client
            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write("Hello, Client!".getBytes());
            outputStream.close();
            clientSocket.close();
        }
    }
}