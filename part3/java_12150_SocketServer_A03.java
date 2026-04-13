import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_12150_SocketServer_A03 {
    private final static String SALT = "SALT";
    private final static String HMAC = "HMAC";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(SALT.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest(HMAC.getBytes(StandardCharsets.UTF_8));

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server started. Listening for connections on port 8080...");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                String request = new String(socketChannel.readCharBuffer().array(), StandardCharsets.UTF_8);
                if (request.contains("INJECT")) {
                    String[] parts = request.split("INJECT");
                    String payload = parts[1];
                    System.out.println("Received payload: " + payload);
                    // Inject payload into the payload using HMAC and SHA-256
                    md.update(payload.getBytes(StandardCharsets.UTF_8));
                    byte[] injectedDigest = md.digest();
                    String injectedPayload = Base64.getEncoder().encodeToString(injectedDigest);
                    System.out.println("Injected payload: " + injectedPayload);
                } else {
                    System.out.println("Received: " + request);
                }
                socketChannel.write(ByteBuffer.wrap(("HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain; charset=utf-8\r\n" +
                        "\r\n" +
                        injectedPayload).getBytes(StandardCharsets.UTF_8)));
                socketChannel.close();
            }
        }
    }
}