import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_10089_SocketServer_A01 {

    private static final String SSL_KEYSTORE = "keystore.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "password";
    private static final String SSL_TRUSTSTORE = "truststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "password";

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(0);
        sslServerSocket.setNeedClientAuthentication(true);

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream(SSL_KEYSTORE), SSL_KEYSTORE_PASSWORD.toCharArray());

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(new FileInputStream(SSL_TRUSTSTORE), SSL_TRUSTSTORE_PASSWORD.toCharArray());

        SSLServerSocketFactory sslServerSocketFactorySecure = (SSLServerSocketFactory) sslServerSocketFactory.createServerSocketFactory(new SSLServerSocketFactoryContext(keyStore, trustStore));

        while (true) {
            Socket socket = sslServerSocketFactorySecure.accept();
            executor.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_10089_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String message;
                while ((message = bufferedReader.readLine()) != null) {
                    System.out.println("Received: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}