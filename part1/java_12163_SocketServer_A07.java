import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_12163_SocketServer_A07 {

    private static final int PORT = 8080;
    private static final String CLIENT_KEY_STORE = "client.jks";
    private static final String CLIENT_KEY_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            System.out.println("Server listening on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted a new client");
                SSLSocket clientSSLSocket = (SSLSocket) clientSocket.getRemoteSocket();
                SSLCertificate certificate = clientSSLSocket.getCertificate();
                System.out.println("Client certificate: " + certificate.toString());
                ExecutorService executor = Executors.newFixedThreadPool(10);
                executor.execute(new SSLWorker(clientSSLSocket, clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
        }
    }

    private static class SSLWorker implements Runnable {
        private final SSLSocket sslSocket;
        private final Socket socket;

        public java_12163_SocketServer_A07(SSLSocket sslSocket, Socket socket) {
            this.sslSocket = sslSocket;
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = sslSocket.getInputStream();
                OutputStream output = sslSocket.getOutputStream();
                byte[] bytes = new byte[1024];
                int length = input.read(bytes);
                String response = new String(bytes, 0, length);
                System.out.println("Received: " + response);
                output.write("OK\n".getBytes());
                output.flush();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}