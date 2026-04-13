import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class java_31559_SocketServer_A01 {
    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        int port = 12345;
        ServerSocketChannel serverSocketChannel = null;
        ServerSocket serverSocket = null;

        try {
            // Set up a ServerSocket to accept incoming connections
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(port));
            serverSocket.setReuseAddress(true);

            // Set up a ServerSocketChannel to accept incoming connections
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            serverSocketChannel.configureBlocking(false);

            logger.info("Server is bound to port " + port + ". Waiting for client connection...");

            while (true) {
                SocketChannel clientSocketChannel = serverSocketChannel.accept();
                if (clientSocketChannel != null) {
                    Channels.setOption(clientSocketChannel, Channels.ChannelOption.ALLOCATOR_EXECUTOR, Channels.providerExecutor());
                    new EchoHandler(clientSocketChannel).start();
                }
            }
        } catch (IOException ex) {
            logger.severe("IOException occurred while setting up ServerSocket or ServerSocketChannel: " + ex.getMessage());
        } finally {
            try {
                if (serverSocketChannel != null) serverSocketChannel.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                logger.severe("IOException occurred while closing ServerSocket or ServerSocketChannel: " + ex.getMessage());
            }
        }
    }
}

class EchoHandler extends Thread {
    private final SocketChannel socketChannel;

    public java_31559_SocketServer_A01(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public void run() {
        byte[] bytes = new byte[1024];
        try {
            StringBuilder output = new StringBuilder();
            int bytesNumRead;
            while ((bytesNumRead = socketChannel.read(bytes)) >= 0) {
                output.append(new String(bytes, 0, bytesNumRead));
            }

            socketChannel.write(output.toString().getBytes());
            socketChannel.close();
        } catch (IOException ex) {
            logger.severe("IOException occurred: " + ex.getMessage());
        }
    }
}