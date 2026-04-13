import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_33853_SocketServer_A07 {
    private static final String SSL_KEY_STORE = "path_to_your_key_store";
    private static final String SSL_KEY_STORE_PASSWORD = "your_key_store_password";
    private static final String SSL_TRUST_STORE = "path_to_your_trust_store";
    private static final String SSL_TRUST_STORE_PASSWORD = "your_trust_store_password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = (SSL_TRUST_STORE == null) ? 
                new ServerSocket(8080) : 
                new SSLServerSocket(8080, SSL_TRUST_STORE, SSL_TRUST_STORE_PASSWORD);
            System.out.println("Waiting for client connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setUseClientMode(true);
            sslSocket.setNeedClientAuth(true);
            sslSocket.setEnableClientMode(true);
            sslSocket.setWantServerAuth(true);
            sslSocket.setEnableServerMode(true);
            sslSocket.setDefaultVerifyMode(SSLSocket.DEFAULT_VERIFY_MODE);
            sslSocket.setNeedClientAuth(true);
            sslSocket.setEnabledProtocols(new String[] { SSLSocket.DEFAULT_PROTOCOL });
            sslSocket.setEnabledCipherSuites(SSLSocket.DEFAULT_CIPHER_SUITES);
            sslSocket.setEnableSessionCache(true);
            sslSocket.setSessionCacheTimeout(10000);
            sslSocket.setSessionCacheSize(10);
            sslSocket.setSessionReused(true);
            sslSocket.setRenegotiate(true);
            sslSocket.setWantClientAuth(true);
            sslSocket.setNeedClientAuth(true);
            sslSocket.setNeedServerAuth(true);
            sslSocket.setEnableServerAuthMode(true);
            DataInputStream inputStream = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(sslSocket.getOutputStream());
            String message = inputStream.readUTF();
            outputStream.writeUTF("Hello Client, Message received");
            outputStream.flush();
            sslSocket.close();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}