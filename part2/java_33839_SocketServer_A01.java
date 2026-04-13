import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_33839_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("localhost", 12345);
        serverSocketChannel.bind(address);
        serverSocketChannel.setOption(ChannelOption.SO_REUSEADDR, true);

        System.out.println("Server is listening on port 12345");

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                System.out.println("Client connected from: " + clientSocketChannel.getRemoteAddress());

                // Check if the client's IP address matches a specific IP
                if (clientSocketChannel.getRemoteAddress().toString().equals("localhost:12345")) {
                    // Access granted, proceed with communication
                    String response = "Access granted";
                    clientSocketChannel.write(ChannelBuffers.wrappedBuffer(response.getBytes()));
                } else {
                    // Access denied, close the connection
                    clientSocketChannel.close();
                    System.out.println("Access denied");
                }
            }
        }
    }
}