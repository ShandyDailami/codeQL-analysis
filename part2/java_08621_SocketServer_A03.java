import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_08621_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();

            SSLCertificate certificate = sslSocket.getSession().getPeerCertificate();
            System.out.println("Client Certificate: " + certificate);

            OutputStream out = sslSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello, Client!");

            SSLSession sslSession = sslSocket.getSession();
            sslSession.close();

            sslSocket.close();
            sslServerSocket.close();

        } catch (SSLException e) {
            e.printStackTrace();
       
        } finally {
            sslServerSocket.close();
            sslSocket.close();
        }
    }
}