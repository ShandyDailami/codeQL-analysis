import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19776_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(443);
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            // read and write data to the socket
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            sslSocket.close();
            sslServerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}