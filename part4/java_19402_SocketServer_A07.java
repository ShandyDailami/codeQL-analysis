import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_19402_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;
        BufferedReader reader = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();

            SSLCertificate cert = sslSocket.getLocalCertificate();
            System.out.println("Client Certificate:" + cert.toString());

            reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println("Received: " + inputLine);
            }

        } finally {
            sslSocket.close();
            sslServerSocket.close();
        }
    }
}