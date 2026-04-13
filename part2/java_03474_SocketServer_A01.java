import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_03474_SocketServer_A01 {
    private static final String KEY_STORE = "src/main/resources/client.jks";
    private static final String KEY_STORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "client";
    private static final SSLServerSocket SERVER_SOCKET;

    static {
        SSLServerSocket serverSocket = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEY_STORE), KEY_STORE_PASSWORD.toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKSAPI");
            keyManagerFactory.init(keyStore, KEY_STORE_PASSWORD.toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunJSSE");
            trustManagerFactory.init(keyStore);
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyManagers(keyManagerFactory.getKeyManagers());
            sslServerSocketFactory.setTrustManagers(trustManagerFactory.getTrustManagers());
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setEnabledCipherSuites(sslServerSocketFactory.getSupportedCipherSuites());
            serverSocket.setEnabledProtocols(sslServerSocketFactory.getSupportedProtocols());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SERVER_SOCKET = serverSocket;
    }

    public static void main(String[] args) throws IOException {
        Socket clientSocket = SERVER_SOCKET.accept();
        SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
        sslSocket.setNeedClientAuth(true);
        sslSocket.setEnabledCipherSuites(sslSocket.getSupportedCipherSuites());
        sslSocket.setEnabledProtocols(sslSocket.getSupportedProtocols());
        BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        DataOutputStream writer = new DataOutputStream(sslSocket.getOutputStream());
        String clientMessage;
        while ((clientMessage = reader.readLine()) != null) {
            System.out.println("Client: " + clientMessage);
            System.out.println("Server: ");
            writer.write((clientMessage + "\r\n").getBytes());
            writer.flush();
        }
        sslSocket.close();
    }
}