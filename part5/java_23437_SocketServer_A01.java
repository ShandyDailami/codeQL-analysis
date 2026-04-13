import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class java_23437_SocketServer_A01 {
    private static final String KEYSTORE_LOCATION = "/path/to/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_LOCATION = "/path/to/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(4444, null, null,
                new javax.net.ssl.SSLContext(javax.net.ssl.SSLContext.TLS_SERVER_SIZER,
                        null, null, null, null));

        System.out.println("Server is running...");

        while (true) {
            SSLSocket sock = (SSLSocket) serverSocket.accept();
            sock.setNeedClientAuth(true);

            // Get input and output streams from the socket
            InputStream is = sock.getInputStream();
            OutputStream os = sock.getOutputStream();

            // Handle client
            handleClient(is, os);

            sock.close();
        }
    }

    private static void handleClient(InputStream is, OutputStream os) {
        // TODO: Handle client
    }
}