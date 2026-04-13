import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_08519_SocketServer_A03 {

    private static final int PORT = 443;
    private static final String KEYSTORE_PATH = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_PATH = "/path/to/your/truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    private final ExecutorService executorService;

    public java_08519_SocketServer_A03() {
        executorService = Executors.newCachedThreadPool();
    }

    public void startServer() throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        serverSocket.setNeedClientAuthentication(true);
        serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());

        System.out.println("Server started");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();

            executorService.execute(new ClientHandler(in, out));
        }
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer();
        server.startServer();
    }

    private class ClientHandler implements Runnable {
        private final InputStream in;
        private final OutputStream out;

        public java_08519_SocketServer_A03(InputStream in, OutputStream out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {
            try {
                byte[] bytes = new byte[1024];
                int length = in.read(bytes);
                System.out.println("Received: " + new String(bytes, 0, length));
                out.write(bytes, 0, length);
            } catch (SocketException e) {
                System.out.println("Client disconnected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}