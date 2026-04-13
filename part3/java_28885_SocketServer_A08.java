import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_28885_SocketServer_A08 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        // Create SSL Server Socket
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);

        // SSLContext for server
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new X509KeyManager[]{new KeyManager()}, new java.security.SecureRandom());
        serverSocket.setSSLContext(sslContext);

        System.out.println("Server started on port 1234");

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client accepted");

            // Create thread to handle communication
            Thread thread = new Thread(new SocketHandler(clientSocket));
            thread.start();
        }
    }

    static class SocketHandler implements Runnable {
        private SSLSocket socket;
        BufferedReader reader;
        PrintWriter writer;

        public java_28885_SocketServer_A08(SSLSocket socket) {
            this.socket = socket;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // process message here
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}