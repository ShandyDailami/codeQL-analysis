import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_32655_SocketServer_A08 {
    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket server = new ServerSocket(port);
        server.setReuseAddress(true);

        System.out.println("Starting server on port " + port);

        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            SSLSocket sslSocket = (SSLSocket) socket.getDefaultSSLSocket();
            sslSocket.setNeedClientAuth(true);

            HandshakeRequestHandler requestHandler = new HandshakeRequestHandler();
            SSLHandshake sh = sslSocket.startHandshake(requestHandler);
            if (!sh.isComplete()) {
                System.out.println("Handshake is not complete");
                continue;
            }

            executor.execute(new SocketHandler(sslSocket));
        }
    }

    static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_32655_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                byte[] b = new byte[1024];
                int length;
                while ((length = input.read(b)) != -1) {
                    output.write(b, 0, length);
                    output.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            socket.close();
        }
    }

    static class HandshakeRequestHandler extends SSLRequestHandler {
        @Override
        public boolean isClientHelloSupported(SSLSocket socket) {
            return false;
        }

        @Override
        public boolean isServerHelloSupported(SSLSocket socket) {
            return false;
        }
    }
}