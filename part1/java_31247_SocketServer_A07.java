import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_31247_SocketServer_A07 {
    private static final int PORT = 443;
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        serverSocket.setNeedClientAuthentication(true);

        System.out.println("Server is listening on port " + PORT);
        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("New connection accepted from " + clientSocket.getRemoteSocketAddress());
            SSLCertificate certificate = clientSocket.getCertificate();
            System.out.println("Client certificate: " + certificate);

            // Continue with the authentication process.
            // ...

            OutputStream out = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello Client, you are connected to the server!");
        }
    }
}