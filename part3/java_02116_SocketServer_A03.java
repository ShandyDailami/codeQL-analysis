import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_02116_SocketServer_A03 {

    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.startHandshake();

                if (sslSocket.getState().name().equals("CLOSED")) {
                    LOGGER.log(Level.WARNING, "Closed connection from {0}", sslSocket.getRemoteSocketAddress());
                    continue;
                }

                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();

                // Reading and writing here is just for demonstration. In real-world use cases, you would probably use a custom protocol.
                byte[] bytes = new byte[1024];
                int bytesRead = inputStream.read(bytes);
                String message = new String(bytes, 0, bytesRead);
                LOGGER.log(Level.INFO, "Received message: {0}", message);

                // Injecting code here. In real-world use cases, you would probably use a custom protocol or a pre-constructed payload.
                if (message.contains("injection")) {
                    LOGGER.log(Level.WARNING, "Detected injection attempt. Closing connection.");
                    sslSocket.close();
                } else {
                    String response = "Message received. Welcome!";
                    outputStream.write(response.getBytes());
                }

                sslSocket.close();
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
}