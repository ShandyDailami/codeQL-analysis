import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_40551_SocketServer_A08 {
    private static final String SSL_PORT = "1234";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketServerSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
            sslServerSocket. setNeedClientAuth(true);

            SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Hello, client, your data is secure!");
            }

            clientSocket.close();
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }
}