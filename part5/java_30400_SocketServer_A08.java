import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_30400_SocketServer_A08 {
    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    LOGGER.info("New connection from: " + socketChannel.socket().getRemoteSocketAddress());

                    socketChannel.configureBlocking(false);

                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    while (socketChannel.read(buffer) != -1) {
                        buffer.flip();
                        // perform security sensitive operation here
                        // for example, decrypting the data
                        byte[] decryptedData = decrypt(buffer.array());
                        buffer.clear();

                        // send the decrypted data back to the client
                        socketChannel.write(ByteBuffer.wrap(decryptedData));
                    }

                    socketChannel.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] decrypt(byte[] data) {
        // implement decryption logic here
        // for example, simple xor operation
        for (int i = 0; i < data.length; i++) {
            data[i] ^= 0x20;
        }
        return data;
    }
}