import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_12137_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(12345, null, null, SSLServerSocket.getDefaultCipherSuites());
        sslServerSocket.setNeedClientAuth(true);

        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.setNeedClientAuth(true);

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        sslSocket.close();
        sslServerSocket.close();
    }
}