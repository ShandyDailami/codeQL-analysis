import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_41648_SocketServer_A01 {
    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, 10, InetAddress.getByName("localhost"));
            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Client connected");
                // Handle the connection here
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}