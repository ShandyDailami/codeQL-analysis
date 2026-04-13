import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_17748_SocketServer_A07 {
    private static final String SALT = "A07_AuthFailure";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] theDigest = md.digest(SALT.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < theDigest.length; i++) {
            sb.append(Integer.toString((theDigest[i] & 0xff) + 0x100, 16).substring(1));
        }
        String generatedPassword = sb.toString();

        SecureRandom sr = new SecureRandom();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb2.append(Integer.toString(sr.nextInt(123456789), 16).substring(2));
        }
        String randomPassword = sb2.toString();

        SocketChannel sc = SocketChannel.open();
        sc.bind(new InetSocketAddress(8080));
        sc.configureBlocking(false);

        System.out.println("Server is listening on port 8080...");

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (true) {
            buf.clear();
            sc.read(buf);
            String request = new String(buf.array(), StandardCharsets.UTF_8).trim();
            System.out.println("Received: " + request);
            if (request.equals(randomPassword)) {
                sc.write(ByteBuffer.wrap("Authentication successful! Welcome to our server.".getBytes(StandardCharsets.UTF_8)));
            } else {
                sc.write(ByteBuffer.wrap("Authentication failed! Please try again.".getBytes(StandardCharsets.UTF_8)));
            }
            sc.write(ByteBuffer.wrap("=".getBytes()));
        }
    }
}