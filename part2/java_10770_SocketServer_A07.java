import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_10770_SocketServer_A07 {
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslSocket = (SSLSocket) sslServerSocket.accept();

            sslSocket.setNeedClientAuth(true);

            in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            out = new PrintWriter(sslSocket.getOutputStream(), true);

            String message = in.readLine();
            if (message != null && message.equals("AUTH " + PASSWORD)) {
                out.println("OK");
            } else {
                out.println("FAIL");
           
            }
        } finally {
            sslSocket.close();
            in.close();
            out.close();
            sslServerSocket.close();
        }
    }
}