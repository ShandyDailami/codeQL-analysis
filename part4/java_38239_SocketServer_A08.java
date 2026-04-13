import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_38239_SocketServer_A08 {
    private static final String CLIENT_KEY = "path_to_your_client_key.key";
    private static final String CLIENT_CERT = "path_to_your_client_cert.crt";

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);
            sslServerSocket.setNeedClientAuth(true);

            SSLSocket sslSocket = null;
            while (true) {
                sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.setNeedClientAuth(true);

                System.out.println("Client connected");
                SSLContext sslContext = sslSocket.getSSLContext();
                InputStream in = sslSocket.getInputStream();
                OutputStream out = sslSocket.getOutputStream();

                DataOutputStream outToClient = new DataOutputStream(out);
                DataInputStream inFromClient = new DataInputStream(in);

                // Authenticate the client
                SSLCertificate cert = sslContext.getCertificate();
                SSLSession sslSession = sslSocket.getSession();
                if (sslSession != null) {
                    System.out.println("Client authenticated");
                }

                // Close the connection
                sslSocket.close();
            }
        } finally {
            sslServerSocket.close();
        }
    }
}