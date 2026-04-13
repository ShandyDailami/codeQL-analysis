import javax.net.ssl.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_37211_SocketServer_A08 {

    private static final String CLIENT_MESSAGE = "Hello from Server!";
    private static final String KEYSTORE_FILE = "client.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_FILE = "truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";
    private static final String SERVER_KEY_ALIAS = "server";
    private static final int PORT = 5000;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuthentication(true);

            KeyStore clientKeyStore = KeyStore.getInstance("JKS");
            clientKeyStore.load(new FileInputStream(KEYSTORE_FILE), KEYSTORE_PASSWORD.toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream(TRUSTSTORE_FILE), TRUSTSTORE_PASSWORD.toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(clientKeyStore, new TrustStorePasswordCallback(trustStore), null);

            ExecutorService executor = Executors.newCachedThreadPool();
            while (true) {
                Socket socket = serverSocket.accept();
                executor.execute(new SocketHandler(socket, sslContext));
            }
        } catch (Exception e) {
            e.printStackTrace();
       
        } finally {
            if (serverSocket != null)
                serverSocket.close();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;
    private SSLContext sslContext;

    public java_37211_SocketServer_A08(Socket socket, SSLContext sslContext) {
        this.socket = socket;
        this.sslContext = sslContext;
    }

    @Override
    public void run() {
        try {
            SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);
            OutputStream outputStream = sslSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            printWriter.println(CLIENT_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TrustStorePasswordCallback implements PasswordCallback {
    private KeyStore trustStore;

    public java_37211_SocketServer_A08(KeyStore trustStore) {
        this.trustStore = trustStore;
    }

    @Override
    public char[] getPassword() {
        return null;
    }

    @Override
    public String getUsername(String s) {
        return trustStore.getEntry(trustStore.getAlias(), null, new BasicCertificate[] {}, null, null);
    }
}