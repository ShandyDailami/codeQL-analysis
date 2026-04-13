import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_34809_SocketServer_A03 {

    private static final String KEYSTORE_LOCATION = "path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "yourKeystorePassword";
    private static final String TRUSTSTORE_LOCATION = "path/to/your/truststore";
    private static final String TRUSTSTORE_PASSWORD = "yourTruststorePassword";

    private final int port;
    private final SSLServerSocketFactory sslServerSocketFactory;
    private final ExecutorService executorService;

    public java_34809_SocketServer_A03(int port, int poolSize) {
        this.port = port;
        this.executorService = Executors.newFixedThreadPool(poolSize);

        sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStorePath(KEYSTORE_LOCATION);
        sslServerSocketFactory.setKeyStorePassword(KEYSTORE_PASSWORD);
        sslServerSocketFactory.setTrustStorePath(TRUSTSTORE_LOCATION);
        sslServerSocketFactory.setTrustStorePassword(TRUSTSTORE_PASSWORD);
    }

    public void start() throws IOException {
        ServerSocket serverSocket = (port == 443) ? (SSLServerSocket) sslServerSocketFactory.createServerSocket(port) : (ServerSocket) new ServerSocket(port);
        System.out.println("Server started on port " + port + " (SSL " + (port == 443 ? "required" : "not required") + ")");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " connected");
            executorService.execute(new SocketHandler(clientSocket));
        }
    }

    public void stop() {
        executorService.shutdown();
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server stopped");
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(443, 10).start();
    }
}