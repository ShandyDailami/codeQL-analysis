import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00378_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
        sslServerSocket.setNeedClientAuth(true);

        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.startHandshake();

        if (sslSocket.getState().equals(Socket.STATE_CLOSE_BY_PEER)) {
            throw new IOException("Connection closed by peer");
        }

        InputStream inputStream = sslSocket.getInputStream();
        OutputStream outputStream = sslSocket.getOutputStream();

        // Read from the input stream
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);

        // Write to the output stream
        String response = "Hello, client!";
        outputStream.write(response.getBytes());

        // Close the connection
        sslSocket.close();
    }
}