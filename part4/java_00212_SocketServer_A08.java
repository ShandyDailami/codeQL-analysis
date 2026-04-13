import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_00212_SocketServer_A08 {
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            // Set up a SSL server socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT);
            sslServerSocket.setNeedClientAuth(true);

            // Accept a client connection
            serverSocket = sslServerSocket.accept();
            socket = serverSocket.accept();

            // Create input and output streams
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            // Create a reader and writer
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream writer = new DataOutputStream(outputStream);

            // Echo back the message
            String message;
            while ((message = reader.readLine()) != null) {
                writer.write(("Echo: " + message).getBytes());
                writer.flush();
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}