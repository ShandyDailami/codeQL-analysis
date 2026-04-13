import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_10203_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new String[]{"TLSv1"}, new java.security.SecureRandom());
            serverSocket.setSSLContext(sslContext);
            System.out.println("Waiting for client connection...");

            clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Server received: " + inputLine);
            }
        } finally {
            clientSocket.close();
            serverSocket.close();
        }
    }
}