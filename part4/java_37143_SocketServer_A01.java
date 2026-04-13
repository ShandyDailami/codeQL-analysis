import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class java_37143_SocketServer_A01 {
    private final int port;
    private SSLServerSocket sslServerSocket;
    private SSLContext sslContext;

    public java_37143_SocketServer_A01(int port) {
        this.port = port;
        init();
    }

    private void init() {
        try {
            // Create a KeyPair
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(new SecureRandom());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Create a SSLContext using the keyPair
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new Key[]{keyPair.getPrivate()}, new SecureRandom());

            // Create a SSLServerSocket using the SSLContext
            sslServerSocket = (SSLServerSocket) sslContext.getServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        new Thread(() -> {
            while (true) {
                try {
                    // Wait for a client to connect
                    SSLSocket client = (SSLSocket) sslServerSocket.accept();
                    System.out.println("Client connected");

                    // Handle the client
                    handleClient(client);

                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }).start();
    }

    private void handleClient(SSLSocket client) {
        // Handle the client here. For simplicity, we'll just print out the client's input
        new Thread(() -> {
            try {
                while (true) {
                    byte[] buffer = new byte[1024];
                    int bytesRead = client.getInputStream().read(buffer);
                    if (bytesRead < 0) {
                        break;
                    }
                    System.out.println(new String(buffer, 0, bytesRead));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        new SecureSocketServer(8000).start();
    }
}