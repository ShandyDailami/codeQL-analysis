import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_12176_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        SSLServerSocketFactory ssf = (SSLServerSocketFactory) ssc.accept();

        while (true) {
            SSLSocket socket = (SSLSocket) ssf.accept();
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);

            writer.println("Hello from the SocketServer!");
            socket.close();
        }
    }
}