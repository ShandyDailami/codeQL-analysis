import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20706_SocketServer_A07 {

    private static final String SERVER_KEYSTORE = "server.jks";
    private static final String SERVER_TRUSTSTORE = "server-truststore.jks";
    private static final String SERVER_TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {

        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(4444);
            serverSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContextBuilder
                    .create()
                    .loadKeyMaterial(SERVER_KEYSTORE, SERVER_TRUSTSTORE, SERVER_TRUSTSTORE_PASSWORD)
                    .build();

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");
                handleClient(clientSocket, sslContext);
            }
        } finally {
            serverSocket.close();
        }
    }

    private static void handleClient(SSLSocket clientSocket, SSLContext sslContext) throws IOException {
        InputStream input = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();

        // read and process request...

        clientSocket.close();
    }
}