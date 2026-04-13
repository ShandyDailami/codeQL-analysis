import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_41605_SocketServer_A08 {
    private static final int PORT = 12345;
    private static final String KEYSTORE_LOCATION = "/path/to/keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_LOCATION = "/path/to/truststore";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            sslServerSocket.setNeedClientAuth(true);

            sslServerSocket.setEnabledSSLProtocols(new String[] { "TLSv1.2" });

            while (true) {
                Socket clientSocket = sslServerSocket.accept();
                System.out.println("Client connected");
                executorService.execute(new SocketHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}