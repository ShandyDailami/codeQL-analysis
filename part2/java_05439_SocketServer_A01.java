import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class java_05439_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8080);
        serverSocketChannel.bind(address);

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            clientSocketChannel.configureBlocking(false);

            ReadableByteChannel clientIn = Channels.newChannel(clientSocketChannel);
            WritableByteChannel clientOut = Channels.newChannel(clientSocketChannel);

            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

            while (clientIn.read(readBuffer) != -1) {
                readBuffer.flip();
                // Perform security-sensitive operations here, e.g., decrypting data
                // ...

                writeBuffer.put(readBuffer);
                writeBuffer.flip();
                clientOut.write(writeBuffer);

                writeBuffer.clear();
            }

            clientSocketChannel.close();
        }
    }
}