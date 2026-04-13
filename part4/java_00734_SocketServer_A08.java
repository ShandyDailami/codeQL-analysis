import javax.net.ssl.*;
import java.net.*;
import java.io.*;

public class java_00734_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            // wrap socket with ssl connection
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuthentication(true);

            // read the certificate from the socket
            SSLCertificate certificate = (SSLCertificate) sslSocket.getCertificate();
            System.out.println("Client Certificate: " + certificate);

            // read the session ID from the socket
            byte[] sessionID = sslSocket.getSessionID();
            System.out.println("Session ID: " + sessionID);

            // verify the server certificate
            boolean verify = sslSocket.verifyServerCertificate();
            System.out.println("Certificate verification: " + verify);

            // read data from socket
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
            }

            // write data to socket
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            out.println("Hello Server!");

            // close the connection
            sslSocket.close();
        } finally {
            sslServerSocket.close();
        }
    }
}