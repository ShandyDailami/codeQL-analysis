import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_40357_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        // Create SSLServerSocket for port 8443 (SSL port)
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443);

        // Setup SSLContext with certificates
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
        sslServerSocket.setSSLContext(sslContext);

        System.out.println("Waiting for client on port 8443...");

        // Accept a connection
        socket = sslServerSocket.accept();
        System.out.println("Client connected");

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Start reading the request
        String request = in.readLine();
        System.out.println("Received: " + request);

        // Send back a response
        out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
        out.flush();

        // Close the connection
        socket.close();
        sslServerSocket.close();
    }
}