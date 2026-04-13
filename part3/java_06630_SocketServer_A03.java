import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_06630_SocketServer_A03 {
    private static final String KEY = "12345678abcdefgh";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuthentication(true);
            serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());
            serverSocket.setKeyManager(new KeyManager[] {
                new KeyManagerSSL()
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            final SSLSocket socket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            System.out.println("Received: " + inputLine);
                        }

                        out.write("Hello Client, you are authenticated!\n");
                        out.flush();

                        socket.close();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            });
        }
    }

    static class KeyManagerSSL implements KeyManager {
        private KeyStore keyStore;

        public java_06630_SocketServer_A03() throws Exception {
            this.keyStore = KeyStore.getInstance("JKS");
            this.keyStore.load(new FileInputStream("server.jks"), KEY.toCharArray());
        }

        public KeyStore getKeyStore() {
            return this.keyStore;
        }

        public char[] getPassword() {
            return KEY.toCharArray();
        }

        public String getAlgorithm() {
            return "SSL";
        }

        public String getKeyAlgorithm() {
            return "SunRSASignature";
        }

        public PrivateKey getPrivateKey() {
            return this.keyStore.getKey(KEY, KEY.toCharArray());
        }
    }
}