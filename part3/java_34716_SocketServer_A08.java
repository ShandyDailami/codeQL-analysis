import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_34716_SocketServer_A08 {

    public static void main(String[] args) throws Exception {

        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);

            SSLCertificate certificate = sslSocket.getSession().getPeerCertificate();
            if (certificate == null) {
                System.out.println("No client certificates available");
            } else {
                System.out.println("Client certificate: " + certificate.toString());
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
                out.write((line + "\n").getBytes());
            }
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
            if (sslSocket != null) {
                sslSocket.close();
            }
        }
    }
}