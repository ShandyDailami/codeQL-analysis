import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_22028_SocketServer_A07 {

    private static final String CLIENT_KEY = "client.key";
    private static final String CLIENT_CERT = "client.cert";
    private static final String SERVER_KEY = "server.key";
    private static final String SERVER_CERT = "server.cert";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        // Load server key and certificate
        KeyStore serverKeyStore = KeyStore.getInstance("JKS");
        serverKeyStore.load(new FileInputStream(SERVER_KEY), "mypassword".toCharArray());

        // Load client key and certificate
        KeyStore clientKeyStore = KeyStore.getInstance("JKS");
        clientKeyStore.load(new FileInputStream(CLIENT_KEY), "mypassword".toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyFactory.getDefaultAlgorithm());
        keyManagerFactory.init(serverKeyStore, "mypassword".toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(new FileInputStream(SERVER_CERT));

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyManagers(keyManagerFactory);
        sslServerSocketFactory.setTrustManagers(trustManagerFactory);

        serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8888);
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8888);

        sslServerSocket.setNeedClientAuthentication(true);

        while (true) {
            Socket clientSocket = sslServerSocket.accept();
            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();

            System.out.println("Client connected");

            out.write("Hello Client, You are connected to Server!".getBytes());
            out.close();

            byte[] data = new byte[1024];
            int bytesRead = in.read(data);
            System.out.println("Server received " + bytesRead + " bytes");

            System.out.println("Server reading data: " + new String(data, 0, bytesRead));

            clientSocket.close();
        }
    }
}