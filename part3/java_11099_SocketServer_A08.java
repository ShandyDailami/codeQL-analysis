import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_11099_SocketServer_A08 {

    private static final int PORT = 8080;
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    private SSLServerSocket sslServerSocket;
    private ServerSocket serverSocket;
    private ExecutorService executorService;

    public java_11099_SocketServer_A08() {
        this.executorService = Executors.newFixedThreadPool(10);
        this.serverSocket = createServerSocket();
        this.sslServerSocket = createSslServerSocket();
    }

    private ServerSocket createServerSocket() {
        try {
            return new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private SSLServerSocket createSslServerSocket() {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) sslServerSocket.getInetSocketAddress().getSocket().getInetSocketAddress().getAddress().getClass().newInstance();
        try {
            return (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        } catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void startServer() {
        System.out.println("Starting server on port " + PORT);
        while (true) {
            try {
                Socket clientSocket = sslServerSocket.accept();
                System.out.println("Accepted a new client from " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        executorService.submit(() -> {
            try (InputStream inputStream = clientSocket.getInputStream();
                 OutputStream outputStream = clientSocket.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new SecureSocketServer().startServer();
    }
}