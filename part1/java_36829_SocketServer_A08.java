import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36829_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            socket = (SSLSocket) serverSocket.accept();

            socket.startHandshake();
            SSLCertificate certificate = socket.getSession().getPeerCertificate();
            System.out.println("Client Certificate: " + certificate.toString());

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (socket != null) socket.close();
        }
    }
}