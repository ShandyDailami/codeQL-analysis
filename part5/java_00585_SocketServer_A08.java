import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_00585_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket sock = null;
        SSLServerSocket sslSock = null;
        SSLSocket sslSockConn = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            // Create a server socket using port 8888
            sock = new ServerSocket(8888);

            // Create an SSL server socket using port 8888 and key store
            sslSock = (SSLServerSocket) sock.accept();

            // Get the SSL socket connection
            sslSockConn = (SSLSocket) sslSock.accept();

            // Get the input and output streams
            in = new DataInputStream(sslSockConn.getInputStream());
            out = new DataOutputStream(sslSockConn.getOutputStream());

            // Read the request
            String request = in.readUTF();

            // Process the request (this is just a placeholder, replace with actual logic)
            String response = "Hello, " + request;

            // Send the response
            out.writeUTF(response);

            // Close the connection
            sslSockConn.close();
        } finally {
            sslSockConn.close();
            sock.close();
        }
    }
}