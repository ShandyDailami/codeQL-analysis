import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

public class java_39744_SocketServer_A08 {
    private static final Logger logger = Logger.getLogger(SecureServer.class.getName());
    private static final String KEY = "0123456789ABCDEF"; // 16 byte key
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) {
        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(8189));
            logger.log(Level.INFO, "Server started.");

            while (true) {
                SocketChannel client = server.accept();
                logger.log(Level.INFO, "New connection from " + client.socket().getRemoteSocketAddress());

                // Create a cipher for encryption
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY.getBytes(), ALGORITHM));

                // Decrypt the client's input and output channels
                Channels.newChannel(client).transferTo(Channels.newChannel(new CipherInputStream(client.socket().getInputStream(), cipher)));
            }
        } catch (IOException | javax.crypto.IllegalBlockSizeException | javax.crypto.BadPaddingSizeException e) {
            logger.log(Level.SEVERE, "Error occurred: " + e.getMessage(), e);
        }
    }
}