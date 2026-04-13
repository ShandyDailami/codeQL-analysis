import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class java_15760_SocketServer_A03 {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try (ServerSocketChannel server = ServerSocketChannel.open()) {
            // Bind to any address, port, but not to a port that's already in use
            server.bind(new InetSocketAddress(0));
            System.out.println("Server listening on port " + server.localAddress().getPort());

            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

            while (true) {
                SocketChannel client = server.accept();
                System.out.println("Accepted connection from " + client.remoteAddress());

                // Use Unsafe methods to read data from the client
                byte[] data = new byte[BUFFER_SIZE];
                while (client.read(buffer) != -1) {
                    // Simulate injection
                    Arrays.fill(data, (byte) 0);
                    buffer.flip();
                    client.write(buffer);
                    buffer.clear();

                    // Simulate delay
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}