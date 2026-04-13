import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;

public class java_23780_SocketServer_A07 {

    private static final String HTPPS = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/plain; charset=UTF-8\r\n" +
            "Content-Length: 13\r\n" +
            "\r\n" +
            "Hello, World!\r\n";

    public static void main(String[] args) throws IOException, CertificateException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(8080));

        while (true) {
            SocketChannel socket = server.accept();
            Channels.newChannel(socket).doTransaction(buffer -> {
                buffer.write(HTPPS.getBytes(StandardCharsets.UTF_8));
                buffer.flip();
                socket.write(ByteBuffer.wrap("Client certificate:\r\n".getBytes(StandardCharsets.UTF_8)));
                buffer.clear();
                socket.read(buffer);
                buffer.flip();
                String response = StandardCharsets.UTF_8.decode(buffer).toString();
                if ("401,14".equals(response)) {
                    throw new AuthFailureException("Authentication failed");
                }
                buffer.clear();
            });
        }
    }
}