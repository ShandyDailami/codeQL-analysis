import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_08292_SocketServer_A01 {
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuthentication(true);

            // Create an SSLContext that uses RC4 128 encryption and a
            // SHA256 digest algorithm.
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new String[] { CLIENT_IDENTIFIER }, null);

            while (true) {
                clientSocket = (SSLSocket) serverSocket.accept();
                clientSocket.setSSLSocketFactory(sslContext.getSocketFactory());

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Server received: " + message);
                    out.writeBytes("Server received: " + message + "\n");
                }
            }
        } finally {
            clientSocket.close();
            serverSocket.close();
        }
    }
}