import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_02295_SocketServer_A03 {
    private static final int PORT = 8888;
    private static SSLServerSocket sslServerSocket;
    private static SSLSocket sslSocket;

    public static void main(String[] args) {
        try {
            // Load the server's certificate and key
            SSLServerCertificate cert = (SSLServerCertificate) SSLServerSocket.selectServerCertificate(new ServerSocket(PORT));
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("path_to_your_keystore"), "your_password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, null);

            // Create the SSLServerSocket
            sslServerSocket = (SSLServerSocket) sslContext.getServerSocket(PORT);

            // Accept a client connection
            sslSocket = (SSLSocket) sslServerSocket.accept();

            // Get the input and output streams
            InputStream in = sslSocket.getInputStream();
            OutputStream out = sslSocket.getOutputStream();

            // Read and write data
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            PrintWriter writer = new PrintWriter(out, true);
            String inputLine;

            // Write a message to the client
            writer.println("Hello, client!");
            writer.flush();

            // Read a message from the client
            inputLine = reader.readLine();
            System.out.println("Server received: " + inputLine);

            // Close the connections
            sslSocket.close();
            sslServerSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}