import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_19500_SocketServer_A01 {

    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(8080));

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("Client connected: " + socketChannel.socket().getRemoteSocketAddress());

                // Here you would handle the communication with the client.
                // For the sake of brevity, this is a simple handshake for now.
                String response = "Welcome to the server!\r\n";
                socketChannel.write(response.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}