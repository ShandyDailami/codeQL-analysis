import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import javax.security.auth.message.callback.AuthCallback;

public class java_04572_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            // Create a SSLServerSocket with an unsecure port (443 for HTTPS)
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(443, null, null, SSLServerSocket.getDefaultCipherSuite());

            // Accept requests from the socket
            Socket socket = sslServerSocket.accept();

            // Get input and output streams
            SSLSocket sslSocket = (SSLSocket) socket;
            InputStream input = sslSocket.getInputStream();
            OutputStream output = sslSocket.getOutputStream();

            // Send back a simple response
            output.write("HTTP/1.1 200 OK\r\n".getBytes());
            output.write("Content-Type: text/html\r\n".getBytes());
            output.write("\r\n".getBytes());

            // Close the socket
            sslSocket.close();
        } finally {
            // Close the server socket
            sslServerSocket.close();
        }
    }
}