import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_40638_SocketServer_A01 {
    private static SSLServerSocket serverSocket;
    private static SSLContext sslContext;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();

        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream keystoreInputStream = new FileInputStream("mykeystore.jks");
        keyStore.load(keystoreInputStream, "mypassword".toCharArray());

        keyStore.getCertificateChain("myalias");

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
        sslServerSocket.setNeedClientAuth(true);

        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, null, null);

        serverSocket = (SSLServerSocket) sslServerSocket;
        serverSocket.setNeedClientAuth(true);

        System.out.println("Waiting for client on port " + serverSocket.getPort());

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        SSLSocket sslSocket = (SSLSocket) clientSocket.getTransport();

        sslSocket.setEnabledProtocols(new String[] { "TLSv1.2" });
        sslSocket.setRequestClientCert(true);

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            out.println(message);
        }
    }
}