import javax.net.ssl.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_25493_SocketServer_A07 {
    private static final int port = 12345;
    private static ExecutorService executor;
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        executor = Executors.newFixedThreadPool(10);

        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
        serverSocket.setNeedClientAuth(true);

        while (true) {
            final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected!");
            Runnable task = new SocketHandler(clientSocket);
            executor.execute(task);
        }
    }

    static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_25493_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                SSLSocket sslSocket = (SSLSocket) socket;
                sslSocket.setNeedClientAuth(true);
                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();

                // Write response here
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println("Server Response");

                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}