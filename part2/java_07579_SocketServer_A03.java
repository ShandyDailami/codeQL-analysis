import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_07579_SocketServer_A03 {
    private final SSLServerSocket serverSocket;

    public java_07579_SocketServer_A03(int port) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
        serverSocket.setNeedClientAuth(true);
    }

    public void startServer() throws IOException {
        System.out.println("Starting server on port " + serverSocket.getLocalPort() + "...");
        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Accepted new client: " + clientSocket.getRemoteSocketAddress());

            SSLCertificate cert = clientSocket.getSession().getCertificate();
            System.out.println("Client certificate: " + cert.toString());

            // Proceed with the client's request...
        }
    }

    public static void main(String[] args) throws Exception {
        new SecureSocketServer(8080).startServer();
    }
}