import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_38347_SocketServer_A03 {
    private static SSLServerSocket sslServerSocket;
    private static SSLSocket sslSocket;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            // Write your response here

            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}