import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_14275_SocketServer_A08 {

    private static ExecutorService execService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = null;
        SSLServerSocket sslServerSocket = null;
        try {
            // Set up SSL server socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);
            ssc = (ServerSocketChannel) sslServerSocket.accept();
            ssc.configureBlocking(false);

            // Create a new SSLSocket and wrap the non-blocking channel with SSLSocket
            SSLSocket sslSocket = (SSLSocket) ssc.accept();
            sslSocket.setNeedClientAuth(true);

            // Create a new input stream from the SSLSocket
            InputStream inputStream = sslSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Now you can read the data from the socket
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Server received: " + line);
            }

            sslSocket.close();
        } finally {
            if (ssc != null) ssc.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}