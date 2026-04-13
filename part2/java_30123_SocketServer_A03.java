import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_30123_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;
        SSLSocket sslSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            serverSocket = new ServerSocket(8000);
            sslServerSocket = (SSLServerSocket) serverSocket;
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setEnabledCipherSuites(new String[] { "SSL_RSA_WITH_RC4_128", "SSL_RSA_EXPORT_WITH_RC4_128", "SSL_SERVER_AUTH_WITH_RC4_128" });
            sslServerSocket.setKeyStore(new java.security.cert.CertificateStore[]{ InetAddress.getByName("localhost").getCertificate().getStore(InetAddress.getByName("localhost").getCertificate().getAlias()) });
            sslServerSocket.setCertificateStore(InetAddress.getByName("localhost").getCertificate().getStore(InetAddress.getByName("localhost").getCertificate().getAlias()));
            sslServerSocket.setKeyStorePassword("password");
            sslServerSocket.setCertificatePassword("password");
            sslServerSocket.setKeyManagerPassword("password");
            socket = sslServerSocket.accept();
            sslSocket = (SSLSocket) socket;
            in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            out = new PrintWriter(sslSocket.getOutputStream(), true);
            System.out.println("Connected to: " + sslSocket.getRemoteSocketAddress().toString());
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Server: " + message);
            }
            sslSocket.close();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
            if (socket != null) socket.close();
            if (sslSocket != null) sslSocket.close();
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }
}