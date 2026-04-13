import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import javax.crypto.*;

public class java_36484_SocketServer_A03 {
    private static final String SSL_PROTOCOL = "SSLv3";
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMER = "AES/CFB/NoPadding";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword("password");

        serverSocket = new ServerSocket();
        serverSocket.bind(serverSocket, 1024);

        System.out.println("Server is running...");

        while (true) {
            socket = serverSocket.accept();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createSocket(socket, false);
            sslServerSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance(SSL_PROTOCOL);
            sslContext.init(null, new TrustManager[] {new TrustAllCerts()}, new java.security.SecureRandom());

            SSLSocket sslSocket = (SSLSocket) sslContext.getSocketFactory().createSocket(sslServerSocket);
            sslSocket.startHandshake();

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            String message = in.readLine();
            System.out.println("Received: " + message);

            out.writeUTF("Hello Client!");
            out.flush();

            sslSocket.close();
        }
    }
}