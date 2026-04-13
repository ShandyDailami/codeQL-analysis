import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;
import javax.net.ssl.SSLSocket;

public class java_32741_SocketServer_A01 {
    private final ExecutorService executor;

    public java_32741_SocketServer_A01() {
        executor = Executors.newCachedThreadPool();
    }

    public void start(int port) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(port));
        server.setOption(ChannelOption.SO_REUSEADDR, true);
        System.out.println("Server is listening on port " + port);
        while (true) {
            SSLSocket client = (SSLSocket) server.accept();
            System.out.println("Client connected");
            executor.execute(new SocketHandler(client));
        }
    }

    private class SocketHandler implements Runnable {
        private final SSLSocket client;

        public java_32741_SocketServer_A01(SSLSocket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                DataOutputStream writer = new DataOutputStream(out);
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                    writer.writeBytes("Hello, client\n".getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer().start(1234);
    }
}