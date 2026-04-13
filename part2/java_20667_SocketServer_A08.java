import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_20667_SocketServer_A08 {

    public static void main(String[] args) throws Exception {

        // Create SSLServerSocket for server
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8443);
        sslServerSocket.setNeedClientAuth(true);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, null, null);

        // Accept client connections and start new threads to handle communication
        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();

            // Get the client's socket input stream
            InputStream is = sslSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            // Get the client's socket output stream
            OutputStream os = sslSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os), true);

            // Read a line of data from the client
            String line = reader.readLine();

            // Write a response to the client
            writer.println("Hello, client!");

            // Close the socket
            sslSocket.close();
        }
    }
}