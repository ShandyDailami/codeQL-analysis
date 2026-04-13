import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_36272_SocketServer_A01 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(8080));

        System.out.println("Server started. Listening for connections...");

        while (true) {
            SocketChannel client = server.accept();

            System.out.println("Client connected: " + client.socket().getRemoteSocketAddress());

            byte[] buffer = new byte[1024];
            int bytesRead = client.read(ByteBuffer.wrap(buffer));

            if (bytesRead < 0) {
                System.out.println("Client disconnected.");
                client.close();
            } else {
                String message = new String(buffer, StandardCharsets.UTF_8);

                // Use SHA-256 hash of the message as the response
                byte[] hash = md.digest(message.getBytes(StandardCharsets.UTF_8));

                client.write(ByteBuffer.wrap(hash));

                client.close();
            }
        }
    }
}