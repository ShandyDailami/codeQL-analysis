import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_08021_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        System.out.println("Server is listening on port 8080");

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("A new client is connected");
                // start a new thread to handle the new client
                new ClientHandler(socketChannel).start();
            }
        }
    }
}

class ClientHandler extends Thread {
    private SocketChannel socketChannel;

    public java_08021_SocketServer_A08(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public void run() {
        try {
            while (true) {
                byte[] bytes = new byte[1024];
                socketChannel.read(bytes);
                // Handle the received data here
                // For the purpose of this example, we're not doing anything with the received data
                // and we're just printing it out
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}