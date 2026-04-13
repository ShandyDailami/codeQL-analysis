import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_28793_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        // Create a SSLServerSocket
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);

        // Accept a client connection
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

        // Get the SSLSocketInput and SSLSocketOutput streams
        SSLInputStream sslIn = new SSLInputStream(sslSocket.getInputStream());
        SSLOutputStream sslOut = new SSLOutputStream(sslSocket.getOutputStream());

        // Create a PrintWriter to send responses
        PrintWriter out = new PrintWriter(sslOut, true);

        // Create a BufferedReader to receive requests
        BufferedReader in = new BufferedReader(new InputStreamReader(sslIn));

        String line;

        // Read the client's request
        while ((line = in.readLine()) != null) {
            System.out.println("Received: " + line);

            // Send a response
            out.println("Hello, client!");

            // Flush the output
            out.flush();
        }

        // Close the SSL socket
        sslSocket.close();
    }
}