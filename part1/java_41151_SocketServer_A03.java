import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_41151_SocketServer_A03 {
    private static final String ALPN = "https";
    private static final SSLServerSocketFactory SERVER_FACTORY;

    static {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory = new SSLServerSocketFactory(new SSLContextBuilder()
                    .loadTrustMaterial(null, (certificate, cn) -> true)
                    .setKeyAndCertificateChainSource(
                            new KeyStoreKeyFactory("Keystore.jks", "password".toCharArray(), "password".toCharArray()))
                    .build(),
                    new TrustSelfSignedStrategy());
            SERVER_FACTORY = sslServerSocketFactory;
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = (ServerSocket) SERVER_FACTORY.createServerSocket(1234,
                (SocketAddress) null,
                0,
                new SSLHandshakeCallback() {
                    public void handshakeComplete(
                            int session,
                            Certificate cert,
                            String[] aliases,
                            SocketAddress serverAddr) throws IOException {

                    }
                });
        System.out.println("Listening on port 1234...");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from: " + socket.getRemoteSocketAddress());
            new SocketHandler(socket).start();
        }
    }

    static class SocketHandler extends Thread {
        private final Socket socket;

        SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (SSLSocket sslSocket = (SSLSocket) socket.getSocket()) {
                System.out.println("Connected to: " + sslSocket.getRemoteSocketAddress());
                InputStream inputStream = sslSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}