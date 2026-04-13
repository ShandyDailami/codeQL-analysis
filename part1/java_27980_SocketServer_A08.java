import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.jna.platform.Windows;
import org.jna.platform.WindowsAccess;

public class java_27980_SocketServer_A08 implements Runnable {

    private ServerSocketChannel ssc;
    private SocketChannel sc;
    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    public java_27980_SocketServer_A08(int port) throws IOException {
        ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        sc = ssc.accept();
    }

    @Override
    public void run() {
        if (sc != null) {
            Windows.handleWindowsAccess(WindowsAccess.GRANT_RESOURCE, 0, 0);
            try {
                sc.configureBlocking(false);
                while ((sc.read(buffer)) != -1) {
                    // Here you can add your security-sensitive operations
                    System.out.println(buffer.flip());
                    Windows.handleWindowsAccess(WindowsAccess.DENY_ACCESS, 0, 0);
                    sc.write(buffer);
                    buffer.clear();
                    Windows.handleWindowsAccess(WindowsAccess.GRANT_RESOURCE, 0, 0);
                }
            } finally {
                sc.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Thread(new SocketServer(8080)).start();
    }
}