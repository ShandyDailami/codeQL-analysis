import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36082_SocketServer_A01 {
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            // Creating SSL Server Socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            // Adding SSL Keystore and Truststore
            serverSocket.setNeedClientAuth(true);
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream("cacerts.jks"), "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, trustStore, null);
            serverSocket.setSSLContext(sslContext);

            System.out.println("Server started");
            // Listen for Client Connection
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection accepted from " + clientSocket.getRemoteSocketAddress());
                new Echoer(clientSocket, sslContext).start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }

    public static class Echoer extends Thread {
        private final Socket socket;
        private final SSLContext sslContext;

        public java_36082_SocketServer_A01(Socket socket, SSLContext sslContext) {
            this.socket = socket;
            this.sslContext = sslContext;
        }

        public void run() {
            BufferedReader in = null;
            PrintWriter out = null;
            try {
                // Create new input and output streams
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Handle echoing the server data
                String echoString;
                while ((echoString = in.readLine()) != null) {
                    System.out.println("Received: " + echoString);
                    // Echo back the received string
                    out.println(echoString);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                // Close the connection
                socket.close();
                out.close();
                in.close();
            }
        }
    }
}