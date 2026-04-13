import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class java_30934_SocketServer_A08 {

    public static void main(String[] args) throws Exception {

        // Set up SSL context
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getDefaultInstance();
        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null, trustManagerFactory.getTrustManagers(), null);

        // Create server socket with SSL
        SSLServerSocketChannel serverSocketChannel = (SSLServerSocketChannel) context.getServerSocketChannel();
        serverSocketChannel.bind(new InetSocketAddress(8443));
        SSLSocket socket = (SSLSocket) serverSocketChannel.accept();

        // Set socket options
        socket.setSoLinger(true, 0);
        socket.setKeepAlive(true);

        // Set up I/O channels
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(8080));
        SocketChannel clientChannel = serverChannel.accept();

        // Communication with client
        while (true) {
            byte[] bytes = new byte[1000];
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int read;
            while ((read = clientChannel.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            System.out.println("Received: " + out.toString());
            clientChannel.write(ByteBuffer.wrap("Hello, client".getBytes()));
        }
    }
}