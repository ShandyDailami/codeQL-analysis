import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_27327_SocketServer_A03 {
    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        ServerSocket serverSocket = (ServerSocket) sslSocketFactory.createServerSocket(8080);
        serverSocket.setReuseAddress(true);

        System.out.println("Server started.");

        while (true) {
            SSLSocket clientSocket = (SSLSocket) sslSocketFactory.createSocket(serverSocket.getLocalSocketAddress(),
                    serverSocket.getPort());

            clientSocket.startHandshake();
            clientSocket.setNeedClientAuth(true);

            SSLSocketFactory sslServerSocketFactory = (SSLSocketFactory) sslSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443);
            sslServerSocket.setReuseAddress(true);

            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();

            byte[] len = new byte[1024];
            int l = is.read(len, 0, 1024);

            System.out.println("Received: " + new String(len, 0, l));

            os.write("Hello Client!".getBytes());
            os.flush();

            clientSocket.close();
            sslServerSocket.close();
        }
    }
}