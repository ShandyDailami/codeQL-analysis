import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class java_34059_SocketServer_A08 {
    private static final String CLIENT_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) SSLServerSocketFactory.createServerSocket(8080, 100000, null, CLIENT_PASSWORD.toCharArray());
        } catch (javax.security.auth.login.CredentialNotFoundException e) {
            System.out.println("Wrong password, cannot start the server.");
            System.exit(1);
        }

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslSocketFactory.createServerSocket(serverSocket.getLocalPort(), 100000, null, CLIENT_PASSWORD.toCharArray());
            sslServerSocket.setNeedClientAuth(true);

            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(socket.getInetAddress(), socket.getPort());
            sslSocket.setNeedClientAuth(true);
            sslSocket.setReadOnly(true);

            SSLClientHandler handler = new SSLClientHandler(sslSocket);

            Thread thread = new Thread(handler);
            thread.start();
        }
    }
}