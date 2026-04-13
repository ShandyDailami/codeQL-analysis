import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.AuthProvider;
import javax.security.ssl.SSLContext;

public class java_09353_SocketServer_A07 {
    private final ExecutorService executor;
    private SSLContext sslContext;

    public java_09353_SocketServer_A07(int port, String keyStorePath, String keyStorePassword, String sslProtocol)
            throws Exception {
        this.executor = Executors.newCachedThreadPool();
        this.sslContext = SSLContext.getInstance(sslProtocol);
        this.sslContext.init(new KeyStoreCallback(keyStorePath, keyStorePassword), null, null);

        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executor.execute(new SocketHandler(clientSocket, sslContext));
        }
    }

    private static class KeyStoreCallback implements CallbackHandler {
        private final String keyStorePath;
        private final String keyStorePassword;

        public java_09353_SocketServer_A07(String keyStorePath, String keyStorePassword) {
            this.keyStorePath = keyStorePath;
            this.keyStorePassword = keyStorePassword;
        }

        @Override
        public java.security.PrivateCredentials[] getRequestedPrivateCredentials() {
            return new java.security.PrivateCredentials[0];
        }

        @Override
        public java.security.cert.Certificate[] getRequestedCertificates() {
            return new java.security.cert.Certificate[0];
        }

        @Override
        public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
            // TODO Auto-generated method stub
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;
        private final SSLContext sslContext;

        public java_09353_SocketServer_A07(Socket socket, SSLContext sslContext) {
            this.socket = socket;
            this.sslContext = sslContext;
        }

        @Override
        public void run() {
            try (Socket socket = this.socket; SSLContext sslContext = this.sslContext) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello, client!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new SocketServer(4444, "client.jks", "password", "SSL");
    }
}