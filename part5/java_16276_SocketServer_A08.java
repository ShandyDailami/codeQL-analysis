import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import javax.crypto.Cipher;

public class java_16276_SocketServer_A08 {

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = { 'T', 'h', 'e', 'B', 'e', 'e', 'k', '2', 'S', 'e', 'c', 'r', 'i', 't', '8', ' ' ,'B', 'y', 'M' };

    private SecretKey originalKey = new SecretKeySpec(keyValue, ALGORITHM);
    private Cipher cipher;

    public java_16276_SocketServer_A08() throws Exception {
        cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, originalKey);
    }

    public static void main(String[] args) {

        SocketServer server = new SocketServer();
        server.start(4445);
    }

    public void start(int port) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port, 10, InetAddress.getByName("localhost"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                handle(socket);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void handle(Socket socket) throws IOException {

        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        byte[] buf = new byte[1024];
        int len = input.read(buf);
        byte[] decoded = new byte[len];
        for (int i = 0; i < len; i++) {
            decoded[i] = (byte)(buf[i] ^ 'r' ^ 'e' ^ 'c' ^ 'u' ^ 'r' ^ 'e' ^ 'd' ^ ' ');
        }

        String decodedString = new String(decoded);
        output.write(decoded);

        socket.close();
    }
}