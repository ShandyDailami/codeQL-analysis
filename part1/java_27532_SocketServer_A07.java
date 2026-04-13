import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_27532_SocketServer_A07 {

    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                socket = sslServerSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream();

                executorService.execute(new SocketHandler(inputStream, outputStream));
            }
        } finally {
            if (sslServerSocket != null) sslServerSocket.close();
            if (socket != null) socket.close();
            executorService.shutdown();
        }
    }

    static class SocketHandler implements Runnable {
        private final InputStream inputStream;
        private final OutputStream outputStream;

        public java_27532_SocketServer_A07(InputStream inputStream, OutputStream outputStream) {
            this.inputStream = inputStream;
            this.outputStream = outputStream;
        }

        @Override
        public void run() {
            // Handle client connection here
        }
    }
}