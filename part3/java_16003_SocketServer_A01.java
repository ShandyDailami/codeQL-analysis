import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_16003_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) clientSocket.getWrappedSocket();

                System.out.println("Client accepted");

                SSLCertificate cert = sslSocket.getSession().getCertificate();
                System.out.println("Certificate fingerprint: " + cert.getFingerprint());

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(sslSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

                String serverMessage = "Hello, client!";
                out.writeBytes("HTTP/1.1 200 OK\r\n\r\n" + serverMessage + "\r\n\r\n");
                out.flush();

                String clientMessage = in.readLine();
                System.out.println("Client says: " + clientMessage);

                clientSocket.close();
            }
        } finally {
            serverSocket.close();
        }
    }
}