import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_00990_SocketServer_A01 {
    private static final int PORT = 4445;
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        ServerSocketChannel ssc;
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            ssc = sslServerSocket.acceptSocket();

            Handler handler = new Handler(ssc.accept());
            executor.submit(handler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler implements Runnable {
        private final SocketChannel socketChannel;
        Handler(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            try {
                socketChannel.configureBlocking(false);
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                while (socketChannel.read(buffer) != -1) {
                    buffer.flip();
                    System.out.println(new String(buffer.array(), 0, buffer.limit()));
                    buffer.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}