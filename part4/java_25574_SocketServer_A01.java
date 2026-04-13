import java.net.*;
import java.io.*;
import java.util.concurrent.*;

import javax.net.ssl.*;
import javax.security.auth.*;

public class java_25574_SocketServer_A01 {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static ServerSocketChannel serverSocketChannel;
    private static Handler handler;

    public static void main(String[] args) throws Exception {
        // Create a SSLContext using TLS
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustAllCertsTrustManager() }, null);

        // Create a server socket
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8443));
        serverSocketChannel.configureBlocking(false);

        // Create a new handler
        handler = new Handler();

        while (true) {
            // Accept a client connection
            SocketChannel clientChannel = serverSocketChannel.accept();
            if (clientChannel != null) {
                // Establish a new SSLSocket
                SSLSocket sslSocket = sslContext.wrapSocketChannel(clientChannel);
                sslSocket.setNeedClientAuth(true);
                executor.execute(new HandlerSocketTask(sslSocket));
            }
        }
    }

    static class HandlerSocketTask implements Runnable {
        private final SSLSocket socket;

        public java_25574_SocketServer_A01(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read from the SSL socket
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                // Write to the SSL socket
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Simulate a security sensitive operation
                    if (request.equals("DROP_PACKET")) {
                        writer.println("Access Denied");
                        writer.flush();
                        socket.close();
                    } else {
                        writer.println("OK");
                        writer.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Close the SSL socket
                socket.close();
            }
        }
    }
}