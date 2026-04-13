import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_15214_SocketServer_A03 {

    private static final String SECRET = "A03_Injection";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(PORT));

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            processRequest(clientChannel);
        }
    }

    private static void processRequest(SocketChannel clientChannel) throws IOException, NoSuchAlgorithmException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        clientChannel.read(buffer);

        String request = new String(buffer.array(), StandardCharsets.UTF_8);

        if (!isRequestSafe(request)) {
            System.out.println("Request is not safe: " + request);
            clientChannel.close();
            return;
        }

        System.out.println("Processing request: " + request);
        clientChannel.close();
    }

    private static boolean isRequestSafe(String request) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(SECRET.getBytes());
        byte[] bytes = md.digest(request.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString().equals(request);
    }
}