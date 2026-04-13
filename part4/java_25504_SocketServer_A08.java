import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_25504_SocketServer_A08 {
    private static final String PASSWORD = "securePassword";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException, SSLException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream inputStream = SecureSocketServer.class.getResourceAsStream("/keystore.jks");
        keyStore.load(inputStream, PASSWORD.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234, keyStore, new javax.net.ssl.SSLServerSocket(serverSocket, keyStore, new javax.net.ssl.SSLServerSocket(serverSocket)) );

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String response;
            if ((response = in.readLine()) != null) {
                out.println("Hello, " + response + ", thanks for connecting!");
            }
       
            clientSocket.close();
        }
    }
}