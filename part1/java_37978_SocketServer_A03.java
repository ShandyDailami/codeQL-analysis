import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_37978_SocketServer_A03 {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        // Initialize SSL Server
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuthentication(true);
            serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());
            serverSocket.setEnabledProtocols(serverSocket.getSupportedProtocols());
        } catch (SSLException ex) {
            System.out.println("SSL Exception: " + ex.getMessage());
            System.exit(1);
        }

        // Start accepting connections
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                Handler handler = new Handler(clientSocket);
                executor.execute(handler);
            } catch (IOException ex) {
                System.out.println("Accept failed: " + ex.getMessage());
                break;
            }
        }

        executor.shutdown();
    }

    static class Handler implements Runnable {
        private Socket socket;
        public java_37978_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Here you can perform operations related to Injection
                }

                socket.close();
            } catch (IOException ex) {
                System.out.println("Error handling: " + ex.getMessage());
            }
        }
    }
}