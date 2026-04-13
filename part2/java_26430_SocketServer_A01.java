import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class java_26430_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8080);
        serverSocketChannel.bind(address);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            System.out.println("A client has connected...");

            // Setup a new thread to handle the client request
            new HandlerThread(clientSocketChannel).start();
        }
    }
}

class HandlerThread extends Thread {
    private SocketChannel socketChannel;

    public java_26430_SocketServer_A01(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            // Read the HTTP request
            byte[] buffer = new byte[1024];
            int bytesRead = socketChannel.read(buffer);

            // Check if request is HTTP
            if (bytesRead < 0) {
                return;
            }

            // Check if request is HTTP GET
            if ("GET".equals(new String(buffer, 0, bytesRead))) {
                // Write HTTP response
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html; charset=utf-8\r\n\r\n" +
                        "<h1>Hello, world!</h1>";
                socketChannel.write(response.getBytes());
            } else {
                // Otherwise, return 403 Forbidden
                String response = "HTTP/1.1 403 Forbidden\r\n" +
                        "Content-Type: text/html; charset=utf-8\r\n\r\n" +
                        "<h1>Forbidden</h1>";
                socketChannel.write(response.getBytes());
            }

            // Close the connection
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}