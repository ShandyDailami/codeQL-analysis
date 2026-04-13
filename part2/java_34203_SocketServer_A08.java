import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Base64;

public class java_34203_SocketServer_A08 {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "12345678abcdefgh"; // 128 bit key

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8189));
        System.out.println("Server started at " + serverChannel.getLocalAddress());

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            System.out.println("Connection accepted from " + clientChannel.getRemoteAddress());

            // Send the message encrypted using AES
            byte[] encryptedMessage = encrypt(clientChannel);
            clientChannel.write(socketBuffer(encryptedMessage));
        }
    }

    private static byte[] encrypt(SocketChannel clientChannel) throws Exception {
        byte[] message = new byte[1024];
        clientChannel.read(buffer(message));

        // AES requires a 16 byte key, so we'll use a simple key
        byte[] key = KEY.getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(message);
    }

    private static ByteBuffer socketBuffer(byte[] bytes) {
        return ByteBuffer.wrap(bytes).flip();
    }
}