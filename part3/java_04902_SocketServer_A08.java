import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_04902_SocketServer_A08 {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Create a server socket using the default port (8080)
            serverSocket = new ServerSocket(8080);

            // Create a SSL server socket using the default port (8080)
            SSLServerSocket sslServerSocketSsl = (SSLServerSocket) serverSocket.accept();

            // Enable SSL
            SSLServerSocket sslServerSocketSslWrapped = new SSLServerSocket(8080, null, Handshake.getDefaultSSLContext());

            // Accept a client connection
            Socket socket = sslServerSocketSslWrapped.accept();

            // Create an input stream from the socket
            InputStream inputStream = socket.getInputStream();

            // Create a reader from the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Read a line of text
            String line = reader.readLine();

            // Print the line in uppercase
            System.out.println(line.toUpperCase());

            // Close the input stream
            reader.close();

            // Close the socket
            socket.close();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}