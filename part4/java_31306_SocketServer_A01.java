import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_31306_SocketServer_A01 {

    private static final String ALGORITHM = "SHA-256";
    private static final int PORT = 8080;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance(ALGORITHM);
        byte[] digest = md.digest("YOUR_PASSWORD_HERE".getBytes());

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(PORT));
        serverChannel.configureBlocking(false);

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (clientChannel != null) {
                byte[] bytes = new byte[1024];
                int bytesRead = clientChannel.read(bytes);
                if (bytesRead == -1) {
                    clientChannel.close();
                    continue;
                }

                String receivedPassword = new String(bytes, 0, bytesRead);

                if (!isPasswordValid(receivedPassword, digest)) {
                    clientChannel.close();
                    System.out.println("Invalid password, closing connection");
                    continue;
                }

                // Handle received password here

                clientChannel.close();
            }
        }
    }

    private static boolean isPasswordValid(String password, byte[] digest) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(ALGORITHM);
        byte[] digestOfPassword = md.digest(password.getBytes());

        return MessageDigest.isEqual(digestOfPassword, digest);
    }
}