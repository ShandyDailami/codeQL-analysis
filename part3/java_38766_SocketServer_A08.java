import javax.net.ssl.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class java_38766_SocketServer_A08 {

    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            // Create a server socket
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(SERVER_PORT);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            serverSocket.setSSLContext(sslContext);

            while (true) {
                // Accept a connection
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                socket.setNeedClientAuth(true);

                // Create a thread to handle the connection
                SocketThread thread = new SocketThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketThread extends Thread {
        private final Socket socket;

        SocketThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Input stream
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                // Output stream
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    writer.println("Hello, client!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class TrustAllCerts extends X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        public void checkClientTrusted(X509Certificate[] certs, String authType) { }
        public void checkServerTrusted(X509Certificate[] certs, String authType) { }
    }
}