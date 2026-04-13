import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_07547_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a ServerSocketChannel and bind it to a port
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));

        System.out.println("Server started. Waiting for client connections...");

        // Listen for incoming connections
        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            System.out.println("New connection accepted from: " + clientSocketChannel.socket().getRemoteSocketAddress());

            // Start a new thread to handle communication with the client
            new HandlerThread(clientSocketChannel).start();
        }
    }
}

class HandlerThread extends Thread {
    private SocketChannel socketChannel;

    public java_07547_SocketServer_A08(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        // Receive a message from the client
        byte[] bytes = new byte[1024];
        try {
            int bytesRead = socketChannel.read(bytes);
            if (bytesRead == -1) {
                socketChannel.close();
                return;
            }

            // Handle the received message, here is a simple echo service
            socketChannel.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}