import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServletException;

public class java_02406_SocketServer_A07 {

    public static void main(String[] args) throws IOException, SSLServletException {
        // Create a SSLServerSocket and bind it to port 8443
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(8443);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 8443. ");
            System.exit(1);
        }

        // Accept client connections
        while (true) {
            try {
                Socket sock = sslServerSocket.accept();
                SSLSocket sslSock = (SSLSocket) sock;

                // Validate client certificate
                sslSock.getSession().put(Session.SESSION_ID_LENGTH, new Integer(1024));
                sslSock.startHandshake();
                sslSock.getSession().setWantClientAuth(true);

                if (sslSock.getSession().getCipherSuites().length < 1) {
                    System.err.println("No Cipher Suites Available");
                    System.exit(1);
                }

                if (sslSock.getNeedClientAuth()) {
                    System.out.println("Client authentication requested");
                    sslSock.setNeedClientAuth(true);

                    // Read client certificate
                    sslSock.setUseClientMode(true);
                    sslSock.setNeedServerAuth(true);

                    sslSock.getSession().setRequestedProtocols(
                            new String[]{"TLSv1.2"});

                    sslSock.getSession().setWantServerAuth(true);

                    sslSock.startHandshake();

                    // Print out the certificate received from client
                    System.out.println("Server Certificate: " + sslSock.getSession().getPeerCertificates());
                } else {
                    System.out.println("No Client Certificate required for authentication");
                }

                // Print out the certificate
                System.out.println("Client Certificate: " + sslSock.getSession().getPeerCertificates());
            } catch (CertificateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}