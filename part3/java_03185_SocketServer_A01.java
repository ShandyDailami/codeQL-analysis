import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_03185_SocketServer_A01 {

    private static final int PORT = 8080;
    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "client.keystore.password";
    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "server.keystore.password";

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT, null, InetAddress.getByName("localhost"));
            serverSocket.setNeedClientAuth(true);

            // Load client keystore
            KeyStore clientKeystore = KeyStore.getInstance("JKS");
            clientKeystore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());

            // Load server keystore
            KeyStore serverKeystore = KeyStore.getInstance("JKS");
            serverKeystore.load(new FileInputStream(SERVER_KEYSTORE), SERVER_KEYSTORE_PASSWORD.toCharArray());

            // Create a TrustStore that contains the certificates of the server and client keystores
            TrustStore trustStore = new trustStoreBuilder()
                    .addCertificate(serverKeystore.getCertificateChain(serverKeystore.getDefaultAlgorithm()))
                    .addCertificate(clientKeystore.getCertificateChain(clientKeystore.getDefaultAlgorithm()))
                    .build();

            serverSocket.setTrustStore(trustStore);

            while (true) {
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                socket.setNeedClientAuth(true);
                executor.execute(new SocketHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_03185_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client connection...
        }
    }
}