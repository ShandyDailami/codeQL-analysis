import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36965_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            SSLServerSocket serverSocket = null;
            SSLSocket clientSocket = null;
            BufferedReader in = null;
            PrintWriter out = null;

            // Load server certificate and key
            SSLServerCertificate cert = (SSLServerCertificate) SSLServerSocketFactory.getDefault().getServerCertificate(serverSocket);
            KeyStore keyStore = KeyStore.getInstance(cert.getType());
            keyStore.load(new FileInputStream(cert.getCertificate().getFile()), "password".toCharArray());

            // Create SSLContext with key store and trust store
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, null);

            serverSocket = (SSLServerSocket) sslContext.getServerSocketFactory().createServerSocket(8443);
            serverSocket.setNeedClientAuth(true);

            System.out.println("Waiting for client on port " + serverSocket.getPort());

            clientSocket = (SSLSocket) serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message, response;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                response = "Hello, client!";
                out.println(response);
            }

            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }
}