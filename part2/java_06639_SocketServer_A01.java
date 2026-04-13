import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_06639_SocketServer_A01 {
    private static final int SERVER_PORT = 8443;
    private static final String KEYSTORE_PATH = "path/to/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "keystorepassword";
    private static final String KEY_ALIAS = "socketkey";

    public static void main(String[] args) throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream inputStream = new java.util.Scanner(System.in).nextLine().equals("y")
                ? new FileInputStream(KEYSTORE_PATH)
                : new FileInputStream("src/main/resources/keystore.jks")) {
            keyStore.load(inputStream, KEYSTORE_PASSWORD.toCharArray());
        }

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT);
        sslServerSocket.setNeedClientAuthentication(true);

        System.out.println("Starting server on port " + SERVER_PORT);
        System.out.println("Accepting client connections...");

        while (true) {
            SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            System.out.println("Client accepted");

            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();

            new ClientHandler(in, out).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final InputStream in;
        private final OutputStream out;

        public java_06639_SocketServer_A01(InputStream in, OutputStream out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}