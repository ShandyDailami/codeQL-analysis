import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_15675_SocketServer_A03 {
    private static final String SSL_PORT = "12345";
    private static final String SERVER_KEYSTORE = "server.jks";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String CLIENT_KEYSTORE = "client.jks";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE = "truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";
    private static SSLServerSocket sslServerSocket;

    public static void main(String[] args) throws IOException, SSLException {
        trustStore();
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory().newSSLServerSocketFactory(new SSLServerSocketFactory.Server(trustStore(), trustStorePassword(), new MySSLSocketImpl(SSL_PORT)));
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String clientMessage = in.readUTF();
            System.out.println("Received message: " + clientMessage);
            out.writeUTF("Server received your message: " + clientMessage);
            socket.close();
        }
    }

    private static KeyStore loadKeyStore(String filename, String password) throws Exception {
        FileInputStream in = new FileInputStream(filename);
        char[] passwordArray = password.toCharArray();
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(in, passwordArray);
        in.close();
        return ks;
    }

    private static TrustStore loadTrustStore() throws Exception {
        return loadTrustStore(TRUSTSTORE, TRUSTSTORE_PASSWORD);
    }

    private static TrustStore loadTrustStore(String filename, String password) throws Exception {
        FileInputStream in = new FileInputStream(filename);
        char[] passwordArray = password.toCharArray();
        TrustStore ts = TrustStore.getInstance(TrustStore.getDefaultType());
        ts.load(in, passwordArray);
        in.close();
        return ts;
    }

    private static KeyStore loadKeyStore() throws Exception {
        return loadKeyStore(SERVER_KEYSTORE, SERVER_KEYSTORE_PASSWORD);
    }

    private static KeyStore loadClientKeyStore() throws Exception {
        return loadKeyStore(CLIENT_KEYSTORE, CLIENT_KEYSTORE_PASSWORD);
    }

    private static KeyStore trustStore() throws Exception {
        return loadTrustStore();
    }

    private static String trustStorePassword() throws Exception {
        return TRUSTSTORE_PASSWORD;
    }

    private static String serverKeyStorePassword() throws Exception {
        return SERVER_KEYSTORE_PASSWORD;
    }

    private static String clientKeyStorePassword() throws Exception {
        return CLIENT_KEYSTORE_PASSWORD;
    }

    private static class MySSLSocketImpl extends SSLSocket {
        MySSLSocketImpl(String s) throws IOException {
            super(InetAddress.getByName("localhost"), 12345);
        }

        public void startHandshake() throws IOException, SSLException {
            SSLServerSocketChannel sslServerSocketChannel = (SSLServerSocketChannel) SSLServerSocket.factory().createServerSocketChannel();
            sslServerSocketChannel.bind(sslServerSocket);
            SSLSocketChannel sslSocketChannel = (SSLSocketChannel) sslServerSocketChannel.accept();
            sslSocketChannel.configureBlocking(false);
            SSLCertificate cert = (SSLCertificate) sslSocketChannel.getSession().getPeerCertificate();
            // do something with cert, e.g., trust it
            sslSocketChannel.handshake();
            super.handshake(sslSocketChannel);
        }
    }
}