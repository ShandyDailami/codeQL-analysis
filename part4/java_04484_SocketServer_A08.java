import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_04484_SocketServer_A08 {
    private static final int PORT = 8443; // SSL port
    private static final String CLIENT_KEYSTORE = "client.jks"; // SSL keystore
    private static final String CLIENT_KEYSTORE_PASSWORD = "client_password"; // SSL keystore password
    private static final String CLIENT_TRUSTSTORE = "client_truststore.jks"; // SSL truststore
    private static final String CLIENT_TRUSTSTORE_PASSWORD = "truststore_password"; // SSL truststore password

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            // Load SSL keystore and truststore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream(CLIENT_TRUSTSTORE), CLIENT_TRUSTSTORE_PASSWORD.toCharArray());

            // Initialize SSLContext with keyStore and trustStore
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, trustStore, null);

            // Create serverSocket and bind it to a port
            serverSocket = (SSLServerSocket) sslContext.getServerSocket(PORT);
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetAddress.getByName("127.0.0.1"), PORT);

            System.out.println("Server started on port: " + PORT);

            while (true) {
                final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Start a new thread to handle communication
                executorService.execute(new Runnable() {
                    public void run() {
                        try {
                            // Get input and output streams
                            InputStream input = clientSocket.getInputStream();
                            OutputStream output = clientSocket.getOutputStream();

                            // Read from input and write to output
                            byte[] bytes = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = input.read(bytes)) != -1) {
                                output.write(bytes, 0, bytesRead);
                            }

                            // Close the connection
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown executorService
            executorService.shutdown();
        }
    }
}