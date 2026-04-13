import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_32517_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                SocketChannel clientChannel = serverSocketChannel.accept();
                System.out.println("Accepted connection from " + clientChannel.socket().getRemoteSocketAddress());

                // Start a new thread to handle the communication with the client
                new HandlerThread(clientChannel).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

class HandlerThread extends Thread {
    private final SocketChannel clientChannel;

    public java_32517_SocketServer_A03(SocketChannel clientChannel) {
        this.clientChannel = clientChannel;
    }

    @Override
    public void run() {
        try {
            // TODO: Perform security-sensitive operations related to A03_Injection

            // Read and write data to and from the client
            byte[] buffer = new byte[1024];
            while (clientChannel.read(buffer) != -1) {
                System.out.println(new String(buffer));
                clientChannel.write(buffer);
            }

            // Close the client connection
            clientChannel.close();
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}