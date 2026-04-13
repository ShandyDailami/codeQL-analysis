import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_20172_SocketServer_A07 {
    private static final String ALGORITHM = "SHA-256";
    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance(ALGORITHM);

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(12345));
        ssc.configureBlocking(false);

        System.out.println("Server is listening on port 12345");

        while (true) {
            SocketChannel sc = ssc.accept();
            if (sc == null) {
                continue;
            }

            sc.configureBlocking(false);

            String clientMessage = receiveData(sc, md);
            if (clientMessage == null) {
                continue;
            }

            String hash = bytesToHex(md.digest(clientMessage.getBytes()));
            if (!isValidUser(hash)) {
                sendData(sc, "Auth failure".getBytes());
                continue;
            }

            sendData(sc, "Welcome to server!".getBytes());
            sc.close();
        }
    }

    private static String receiveData(SocketChannel sc, MessageDigest md) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder sb = new StringBuilder();
        while (sc.read(buffer) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                sb.append((char) buffer.get());
            }
            buffer.clear();
        }
        return sb.toString();
    }

    private static void sendData(SocketChannel sc, byte[] bytes) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes);
        buffer.flip();
        while (buffer.hasRemaining()) {
            sc.write(buffer);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static boolean isValidUser(String hash) {
        return hash.equals(bytesToHex(users.get("user1").getBytes()));
    }
}