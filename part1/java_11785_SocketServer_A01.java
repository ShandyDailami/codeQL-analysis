import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;

public class java_11785_SocketServer_A01 {

    private static final String CLIENT_HOST = "localhost";
    private static final int CLIENT_PORT = 12345;
    private static final String CLIENT_MESSAGE = "Hello, Client";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        SSLServerSocketChannel sslServerSocketChannel = SSLServerSocketChannel.open();
        sslServerSocketChannel.bind(new InetSocketAddress(12345));
        sslServerSocketChannel.setNeedClientAuthentication(true);

        // Create a new socket to handle the SSL handshake
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketChannel.accept();
        serverSocket.setNeedClientAuthentication(true);

        // Create a new channel and bind the server socket to the channel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(12345));

        // Accept incoming client connections
        SocketChannel clientChannel = serverChannel.accept();

        // Send the client a message
        clientChannel.write(ByteBuffer.wrap(CLIENT_MESSAGE.getBytes(StandardCharsets.UTF_8)));

        // Read the server's response
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        clientChannel.read(buffer);
        System.out.println("Server says: " + new String(buffer.array(), StandardCharsets.UTF_8));

        // Close the channels
        clientChannel.close();
        serverChannel.close();
    }
}