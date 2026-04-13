import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_15935_SocketServer_A07 {

    public static void main(String[] args) throws IOException, CertificateException, UnsupportedCallbackException {
        // Create a server socket with SSL
        ServerSocket serverSocket = (ServerSocket) new SSLServerSocket(8443);

        // Accept a client connection
        Socket socket = serverSocket.accept();

        // Create a SSL socket
        SSLSocket sslSocket = (SSLSocket) socket.createChannel();

        // Set the truststore for SSL socket
        sslSocket.setNeedClientAuth(true);
        sslSocket.setTruststore(Truststore.getInstance());

        // Perform the SSL handshake
        sslSocket.handshake();

        // Perform the authentication
        sslSocket.getSession().setAuthStatus(sslSocket.getSession().getAuthStatus() + 1);

        // Do something with the SSLSocket
        // ...

        // Close the SSLSocket
        sslSocket.close();
    }

}