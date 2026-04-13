import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddr;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_19106_SocketServer_A08 {
    private static final String ALGORITHM = "AES";
    private static final byte[] key = "thisisaeskey123".getBytes();

    public static void main(String[] args) throws Exception {
        Socket socket = null;
        SSLSocket sslSocket = null;

        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(4444, null, null, null);
            System.out.println("Server is listening on port 4444");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected");

                sslSocket = (SSLSocket) socket.createInstance("SSL");
                Objects.requireNonNull(sslSocket).setEnabledProtocols(new String[]{"TLS"});

                sslSocket.setSoLinger(true, -1);
                sslSocket.setUseClientMode(true);
                sslSocket.setNeedClientAuth(true);
                sslSocket.setCertificates(null);

                sslSocket.startHandshake();
                sslSocket.setSoTimeout(60000);

                InputStream is = sslSocket.getInputStream();
                OutputStream os = sslSocket.getOutputStream();

                byte[] buf = new byte[1024];
                int len = is.read(buf);
                while (len != -1) {
                    Cipher cipher = Cipher.getInstance(ALGORITHM);
                    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, ALGORITHM));

                    byte[] decryptedData = cipher.doFinal(buf, 0, len);
                    String decryptedString = new String(decryptedData);

                    System.out.println("Decrypted Data: " + decryptedString);

                    os.write(decryptedData);
                    os.flush();

                    len = is.read(buf);
                }

                sslSocket.close();
            }
        } finally {
            if (socket != null) socket.close();
            if (sslSocket != null) sslSocket.close();
        }
    }
}