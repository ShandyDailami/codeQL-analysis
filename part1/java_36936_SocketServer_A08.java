import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_36936_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Client accepted");

                SSLCertificate SSLcert = clientSocket.getSession().getCertificate();
                System.out.println("Client certificate: " + SSLcert.toString());

                OutputStream out = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello Client, Successfully Connected!");
            }
        } catch (SSLException e) {
            System.out.println("SSLException was caught");
        } finally {
            clientSocket.close();
            serverSocket.close();
        }
    }
}