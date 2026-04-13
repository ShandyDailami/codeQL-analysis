import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_01673_SocketServer_A07 {

    private static final int PORT = 8888;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);
        ServerSocketChannel serverSocketChannel = null;
        SSLServerSocket sslServerSocket = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);
            sslServerSocket = (SSLServerSocket) serverSocketChannel.accept();
            sslServerSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContextBuilder.createDefault().build();
            SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(sslServerSocket);
            sslSocket.setNeedClientAuth(true);
            System.out.println("Client Authentication Required.");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocketChannel != null)
                serverSocketChannel.close();
            if (sslServerSocket != null)
                sslServerSocket.close();
            if (executor != null)
                executor.shutdown();
        }
    }
}