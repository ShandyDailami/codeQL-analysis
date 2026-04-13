import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_21066_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8080);
        serverSocketChannel.bind(address);
        System.out.println("Server started on port 8080");

        while (true) {
            SocketChannel clientChannel = serverSocketChannel.accept();
            System.out.println("New connection from " + clientChannel.socket().getRemoteSocketAddress());

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            clientChannel.read(buffer);
            String message = new String(buffer.array(), 0, buffer.position());
            System.out.println("Received: " + message);

            buffer.clear();
            clientChannel.close();
       
        }
    }
}