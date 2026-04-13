import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_33780_SocketServer_A03 {
    private static final String PASSWORD = "secure";
    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;
        Socket connection = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            // Create a server socket
            socket = new ServerSocket(PORT);
            // Set up SSL context and key manager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            KeyStore keyStore = KeyStore.getInstance("JKS");
            // Initialize key store
            keyStore.load(new FileInputStream("server.jks"), PASSWORD.toCharArray());
            sslContext.init(keyStore, null, null);
            // Setup socket with SSL
            sslSocket = (SSLServerSocket) sslContext.getServerSocket(socket);
            connection = sslSocket.accept();
            // Set up input and output streams
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new PrintWriter(connection.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Server received your message: " + inputLine);
           
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (sslSocket != null) {
                sslSocket.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}