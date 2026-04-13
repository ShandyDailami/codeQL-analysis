import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_23340_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from: " + clientSocket.getRemoteSocketAddress());
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();

                SSLInputStream sslIn = new SSLInputStream(sslSocket.getInputStream());
                SSLOutputStream sslOut = new SSLOutputStream(sslSocket.getOutputStream());

                // Start SSL Handshake
                SSLSession sslSession = sslOut.getSession();
                sslSession.setWantServerAuth(true);
                sslOut.handshake();

                SSLCertificate cert = sslSession.getPeerCertificate();
                if (cert == null) {
                    System.out.println("No SSL certificate presented by the client.");
                } else {
                    System.out.println("Client SSL certificate:" + cert.toString());
                }

                sslOut.close();
                sslIn.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}