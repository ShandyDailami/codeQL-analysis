import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class java_30129_SocketServer_A08 {

    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_password";
    private static final String KEY_PASSWORD = "your_key_password";

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5000);
            serverSocket.setNeedClientAuth(true);
            SSLServerSocketFactory sslServerSocketFactory1 = (SSLServerSocketFactory) sslServerSocketFactory1.createServerSocketFactory();
            SSLSocket clientSocket = (SSLSocket) sslServerSocketFactory1.createSocket(serverSocket.getInetAddress(), serverSocket.getPort());
            clientSocket.startHandshake();
            clientSocket.setNeedClientAuth(true);
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // Start the communication in a new thread
            new Thread(() -> {
                byte[] bytes = new byte[1024];
                int length;
                while ((length = inputStream.read(bytes)) != -1) {
                    System.out.println(new String(bytes, 0, length));
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}