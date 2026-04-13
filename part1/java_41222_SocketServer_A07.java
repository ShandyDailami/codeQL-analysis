import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_41222_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLServer socketServer = new SSLServer();
        socketServer.startServer();
    }

    private SSLServerSocket serverSocket;

    private void startServer() throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5000);
        serverSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Server received: " + line);
                out.writeBytes("Server received: " + line + "\n");
            }

            clientSocket.close();
        }
    }

    class SSLServerSocketFactory extends SSLServerSocketFactory {
        public java_41222_SocketServer_A07() {
            super(new SSLContext());
        }

        @Override
        public SSLServerSocket createServerSocket(int port) throws IOException {
            SSLServerSocket srvrSocket = super.createServerSocket(port);
            srvrSocket.setNeedClientAuth(true);
            return srvrSocket;
        }
    }

    class SSLContext extends SSLContextImpl {
        private java_41222_SocketServer_A07() {
            try {
                SSLCertificate cert = new SSLCertificateImpl(
                    "src/main/resources/server.pem",
                    "src/main/resources/server.pem");

                SSLCertificate[] certs = new SSLCertificate[]{cert};

                KeyStore keystore = KeyStore.getInstance("JKS");
                keystore.load(new FileInputStream("src/main/resources/keystore.jks"), "keystorepassword".toCharArray());

                TrustManagerFactory trustManagerFactory = new TrustManagerFactory();
                trustManagerFactory.init(new KeyStoreInputStream(keystore, "truststorepassword".toCharArray()));

                KeyManagerFactory keyManagerFactory = new KeyManagerFactory();
                keyManagerFactory.init(new KeyStoreInputStream(keystore, "keystorepassword".toCharArray()), "keystorepassword".toCharArray());

                super.init(keystore, trustManagerFactory.getTrustManagers(), keyManagerFactory.getKeyManagers(), null);
            } catch (Exception ex) {
                throw new Error(ex);
            }
        }
    }

    class SSLCertificateImpl extends SSLCertificate {
        private java_41222_SocketServer_A07(String certificateFile, String privateKeyFile) throws IOException {
            super(certificateFile, privateKeyFile);
        }

        public java_41222_SocketServer_A07(String certificateFile) {
            super(certificateFile);
        }
    }

    class SSLCertificateKeyImpl extends SSLCertificateKey {
        private java_41222_SocketServer_A07(String keyFile) throws IOException {
            super(keyFile);
        }
    }

    class SSLContextImpl extends SSLContext {
        private java_41222_SocketServer_A07() {
        }

        public void init(KeyStore keystore, TrustManager[] trustManagers, KeyManager[] keyManagers, String protocol) throws SSLException {
        }
    }

    class KeyStoreInputStream extends InputStream {
        private java_41222_SocketServer_A07(KeyStore keystore, char[] password) throws IOException {
        }

        public int read() throws IOException {
            return 0;
        }
    }

    class TrustManagerFactory {
        private TrustManager[] trustManagers;

        public TrustManager[] getTrustManagers() {
            return trustManagers;
        }

        public void init(KeyStore keystore, char[] password) throws GeneralSecurityException {
        }
    }

    class KeyManagerFactory {
        private KeyManager[] keyManagers;

        public KeyManager[] getKeyManagers() {
            return keyManagers;
        }

        public void init(KeyStore keystore, char[] password) throws GeneralSecurityException {
        }
    }

    class SSLException extends Exception {
    }
}