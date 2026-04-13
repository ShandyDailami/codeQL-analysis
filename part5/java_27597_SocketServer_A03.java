import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServletException;

public class java_27597_SocketServer_A03 {

    public static void main(String[] args) throws IOException, SSLServлетException, CertificateException {
        boolean useSsl = true;
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        if (useSsl) {
            serverSocket = new ServerSocket(8080);
            sslServerSocket = (SSLServerSocket) serverSocket;
            System.out.println("Server started. Listening on " + sslServerSocket.getInetAddress().getHostAddress() + " port " + sslServerSocket.getLocalPort());
        } else {
            serverSocket = new ServerSocket(8080, 50000);
            System.out.println("Server started. Listening on " + serverSocket.getInetAddress().getHostAddress() + " port " + serverSocket.getLocalPort());
        }

        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("Client connected from " + socket.getInetAddress().getHostAddress());

            SSLSocket sslSocket = (SSLSocket) socket;
            sslSocket.startHandshake();
            sslSocket.getCertificate().verify(sslSocket.getSession());

            // Here you can use the sslSocket object for the communication with the client
        }
    }
}