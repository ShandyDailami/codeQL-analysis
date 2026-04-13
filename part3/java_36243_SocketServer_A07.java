import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36243_SocketServer_A07 {
    private static final String CLIENT_IDENTIFIER = "Client";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            // Create SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new X509KeyManager[] { new X509KeyManager() }, new java.security.SecureRandom());

            // Set up the SSLSocketFactory with our SSLContext
            SSLServerSocket serverSSLSocket = (SSLServerSocket) sslContext.getServerSocketFactory().createServerSocket(12345);
            serverSSLSocket.setNeedClientAuth(true);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSSLSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Hello Client, you are connected to port 12345");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                }
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}