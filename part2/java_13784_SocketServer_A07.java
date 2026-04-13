import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_13784_SocketServer_A07 {
    private SSLServerSocket serverSocket;
    private SSLContext sslContext;

    public java_13784_SocketServer_A07(int port) {
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
        try {
            serverSocket = (SSLServerSocket)sslServerSocketFactory.createServerSocket(port);
            serverSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + port);
            System.exit(-1);
        }
    }

    public void startServer() {
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected!");
            SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
            sslSocket.setNeedClientAuth(true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());
            // Send SSL handshake result
            out.write(("HTTP/1.1 200 OK\r\n\r\n").getBytes());
            out.flush();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);
            }
            in.close();
            out.close();
            sslSocket.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = null;
        try {
            SSLServerSocket serverSocket = new SSLServerSocket(4444);
            sslServerSocketFactory = (SSLServerSocketFactory) serverSocket.getServerSocketFactory();
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + 4444);
            System.exit(-1);
        }
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("truststore.jks"), "truststorepassword".toCharArray());
        } catch (IOException e) {
            System.out.println("Could not load key store");
            System.exit(-1);
        }
        KeyStore keyStoreClient = null;
        try {
            keyStoreClient = KeyStore.getInstance("JKS");
            keyStoreClient.load(new FileInputStream("keystore.jks"), "keystorepassword".toCharArray());
        } catch (IOException e) {
            System.out.println("Could not load client key store");
            System.exit(-1);
        }
        TrustManagerFactory trustManagerFactory = null;
        try {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(new KeyStoreTrustStore(keyStore));
        } catch (KeyManagementException e) {
            System.out.println("Could not initialize trust manager factory");
            System.exit(-1);
        }
        SSLServer sslServer = new SSLServer(4444, sslServerSocketFactory, trustManagerFactory, keyStoreClient);
        sslServer.startServer();
    }
}