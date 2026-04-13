import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_28413_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Initialize server socket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        // Initialize datagram channel for receiving and sending UDP datagrams
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.bind(new InetSocketAddress(8081));

        System.out.println("Server is listening on port 8080...");

        while (true) {
            // Accept client connection
            SocketChannel clientChannel = serverSocketChannel.accept();
            System.out.println("Client connected from " + clientChannel.socket().getRemoteSocketAddress());

            // Receive a message from the client
            byte[] buffer = new byte[1024];
            clientChannel.read(ByteBuffer.wrap(buffer));
            String message = new String(buffer, "UTF-8");
            System.out.println("Received message: " + message);

            // Send a response back to the client
            byte[] response = ("Hello, Client!").getBytes();
            datagramChannel.send(ByteBuffer.wrap(response), clientChannel.socketAddress());
        }
    }
}