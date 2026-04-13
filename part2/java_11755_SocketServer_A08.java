import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_11755_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            // Create an SSLServerSocket and accept a connection
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setEnabledCipherSuites(new String[]{"SSL_RSA_WITH_AES_128_CBC_SHA", "SSL_DSS_WITH_AES_128_CBC_SHA", "SSL_RSA_WITH_RC4_128_SHA", "SSL_DSS_WITH_RC4_128_SHA"}); // These are the cipher suites that your server supports
            serverSocket.setNeedClientAuth(true); // This is for client authentication

            // Accept a connection
            socket = (SSLSocket) serverSocket.accept();
            socket.setNeedClientAuth(true); // This is for client authentication

            // Create an SSLSocketInput and SSLSocketOutput and start reading and writing
            SSLInputStream sslIn = new SSLInputStream(socket.getInputStream());
            SSLOutputStream sslOut = new SSLOutputStream(socket.getOutputStream());

            // Write the response
            sslOut.write("HTTP/1.1 200 OK\r\n");
            sslOut.write("Content-Type: text/plain; charset=UTF-8\r\n");
            sslOut.write("\r\n");
            sslOut.write("Hello, client!\r\n");
            sslOut.flush();

            // Close the connection
            socket.close();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (socket != null) socket.close();
        }
    }
}