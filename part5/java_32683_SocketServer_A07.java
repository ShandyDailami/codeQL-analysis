import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_32683_SocketServer_A07 {
    private static final String PASSWORD = "password";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        try (ServerSocketChannel server = ServerSocketChannel.open()) {
            server.bind(new InetSocketAddress(PORT));
            System.out.println("Server started on port " + PORT);

            while (true) {
                SocketChannel client = server.accept();
                executor.execute(new ClientHandler(client));
            }
        }
    }

    static class ClientHandler implements Runnable {
        private final SocketChannel client;

        ClientHandler(SocketChannel client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // read password from client
                byte[] bytes = new byte[PASSWORD.length()];
                client.read(ByteBuffer.wrap(bytes));

                // compare passwords
                if (!PASSWORD.equals(new String(bytes))) {
                    System.out.println("Auth failure!");
                    client.close();
                    return;
                }

                // if password correct, respond with a welcome message
                client.write(ByteBuffer.wrap("Welcome!".getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
                client.close();
            }
        }
    }
}