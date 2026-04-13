import java.net.Socket;
import java.io.OutputStream;
import java.io.IOException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_25952_SocketServer_A08 {

    private static final String KEYSTORE_LOCATION = "/path/to/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_LOCATION = "/path/to/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
        sslServerSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);

            OutputStream outputStream = sslSocket.getOutputStream();
            outputStream.write("Hello, client!\n".getBytes());
            outputStream.flush();

            sslSocket.close();
        }
    }
}