import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_21140_SocketServer_A07 {
    private static final String SSL_PORT = "443"; // SSL port
    private static final String REMOTE_IP = "127.0.0.1"; // Local IP

    public static void main(String[] args) throws IOException, CertificateException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        ServerSocket sslServerSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT), 128, REMOTE_IP);
        sslServerSocket.setNeedClientAuth(true);
        Socket socket = sslServerSocket.accept();
        System.out.println("Client connected");

        SSLSocket sslSocket = (SSLSocket) socket;
        sslSocket.startHandshake();
        System.out.println("Handshake completed");

        // Output the certificate
        OutputStream out = sslSocket.getOutputStream();
        out.write("Server certificate:\n".getBytes());
        sslSocket.getSession().getCertificateChain().eachCert(new CertificateOutputAction(out));
        out.close();

        InputStream in = sslSocket.getInputStream();
        byte[] b = new byte[100];
        int length;
        while ((length = in.read(b)) != -1) {
            System.out.println(new String(b, 0, length));
        }

        sslSocket.close();
    }

    private static class CertificateOutputAction implements java.security.cert.Action {
        private OutputStream out;

        public java_21140_SocketServer_A07(OutputStream out) {
            this.out = out;
        }

        public void run(java.security.cert.Certificate[] certificates) throws CertificateException, IOException {
            for (Certificate cert : certificates) {
                out.write(cert.toString().getBytes());
            }
        }
    }
}