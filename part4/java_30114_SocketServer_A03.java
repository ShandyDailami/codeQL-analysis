import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_30114_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            SSLCertificate certificate = clientSocket.getSSLCertificate();
            String subject = certificate.getSubjectDN().toString();

            System.out.println("Client SSL Certificate Subject: " + subject);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);
                out.println("Server Response: Hello, client!");
            }
        } finally {
            serverSocket.close();
        }
    }
}