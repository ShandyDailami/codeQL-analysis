import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_28191_SocketServer_A03 {

    private static final String SSL_PORT = "5000";
    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketServerSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
            serverSocket.setNeedClientAuth(true);
            serverSocket.setUseClientMode(true);
        } catch (Exception ex) {
            System.out.println("SSL Server initialization failed. Exiting.");
            ex.printStackTrace();
            System.exit(1);
        }

        executor = Executors.newCachedThreadPool();
        System.out.println("Secure Socket Server is running");
        while (true) {
            try {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Connection established from " + clientSocket.getRemoteSocketAddress());
                Handler handler = new Handler(clientSocket);
                executor.execute(handler);
            } catch (Exception ex) {
                System.out.println("Exception occurred in the handler. Client might not be connected. " + ex);
                ex.printStackTrace();
            }
        }
    }

    static class Handler implements Runnable {
        private final Socket socket;
        private final BufferedReader in;
        private final PrintWriter out;

        public java_28191_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception ex) {
                System.out.println("Exception occurred when setting up stream.");
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            String request;
            try {
                if ((request = in.readLine()) != null) {
                    System.out.println("Received request: " + request);
                    out.println("Server response: " + request);
                }
            } catch (Exception ex) {
                System.out.println("Exception occurred when reading from the stream.");
                ex.printStackTrace();
            }
            socket.close();
        }
    }
}