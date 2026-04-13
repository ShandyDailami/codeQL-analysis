import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_33020_SocketServer_A03 {

    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create executor service to handle multiple threads
        executor = Executors.newCachedThreadPool();

        // Set up SSL ServerSocket
        SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[]{new X509TrustManager()}, null);
        sslServerSocket.setSSLContext(sslContext);

        while (true) {
            // Accept a connection
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            System.out.println("Client connected");

            // Start a new thread for handling each client
            executor.execute(new SocketHandler(sslSocket));
        }
    }

    private static class SocketHandler implements Runnable {
        private Socket socket;

        public java_33020_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                // Read from the input stream and write to the output stream
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String message = reader.readLine();
                System.out.println("Received: " + message);

                // Validate and sanitize the input message
                // Here, we just check if the message is "Hello"
                if ("Hello".equals(message)) {
                    outputStream.write("Hello World\n".getBytes());
                    outputStream.flush();
                } else {
                    outputStream.write("Error: Invalid message\n".getBytes());
                    outputStream.flush();
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}