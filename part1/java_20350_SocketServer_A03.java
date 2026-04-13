import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_20350_SocketServer_A03 {

    public static void main(String[] args) throws Exception {

        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);

            sslServerSocket.setNeedClientAuthentication(true); // Require clients to present client certificates

            sslSocket = (SSLSocket) sslServerSocket.accept();

            sslSocket.startHandshake();

            SSLCertificate certificate = sslSocket.getSession().getPeerCertificate();
            System.out.println("Client certificate: " + certificate.toString());

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            // Write response
            out.writeUTF("Hello, client!");
            out.flush();

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Server received: " + line);
            }

        } finally {
            sslSocket.close();
            sslServerSocket.close();
        }
    }
}