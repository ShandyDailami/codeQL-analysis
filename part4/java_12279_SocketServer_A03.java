import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.*;

public class java_12279_SocketServer_A03 {

    private static SSLServerSocket serverSocket;
    private static Socket clientSocket;

    public static void main(String[] args) throws Exception {
        // Create an SSLServerSocket using SSL/TLS protocol, port 4444
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(4444);
        serverSocket.setEnabledCipherSuites(new String[] { "TLSv1", "TLSv1.1", "TLSv1.2" });
        serverSocket.setNeedClientAuth(true);

        System.out.println("Server started at port 4444");

        while (true) {
            // accept a new connection
            clientSocket = serverSocket.accept();
            System.out.println("Connection accepted from " + clientSocket.getInetAddress().getHostAddress());

            // create a new SSL socket using SSL/TLS protocol
            SSLSocket sslSocket = (SSLSocket) clientSocket.getChannel().newChannel();

            // get the server certificate
            Certificate certificate = sslSocket.getSession().getPeerCertificate();
            System.out.println("Server certificate is " + certificate);

            // set the local certificate
            sslSocket.setLocalCertificate(certificate);

            // set the local key
            sslSocket.setLocalKey(certificate.getPrivateKey());

            // enable server authentication
            sslSocket.setNeedClientAuth(true);

            // start the SSL connection
            sslSocket.handshake();

            // process the request and response
            // here you can read and write data with sslSocket
            // ...

            // close the SSL socket
            sslSocket.close();
        }
    }
}