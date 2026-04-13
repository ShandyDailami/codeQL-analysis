import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_06801_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444);
            sslServerSocket.setEnabledSSL(true);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Connection accepted from " + sslSocket.getRemoteSocketAddress());

                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                }

                sslSocket.close();
            }
        } finally {
            sslServerSocket.close();
        }
    }
}