import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_42116_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080...");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("A client connected");
                socketChannel.configureBlocking(false);

                // Start new thread for handling client requests
                new ClientHandler(socketChannel).start();
            }
        }
    }
}

class ClientHandler extends Thread {
    private SocketChannel socketChannel;

    public java_42116_SocketServer_A07(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] bytes = new byte[1024];
                int length = socketChannel.read(bytes);
                if (length == -1) break; // client closed connection

                // handle received bytes...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}