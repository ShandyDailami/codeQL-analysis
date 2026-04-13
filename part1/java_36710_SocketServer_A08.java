import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_36710_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            // Create a SSLServerSocket and listen on port 8888
            serverSocket = new ServerSocket(8888);

            // Create a new context for the SSL server
            SSLContext sslContext = SSLContext.getInstance("SSL");

            // Initialize the SSLContext with a custom truststore
            SSLServerSocketFactory sslServerSocketFactory = sslContext.wrapServerSocket(serverSocket);

            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket();

            // Accept a client connection
            socket = sslServerSocket.accept();

            System.out.println("Client connected");

            // Create an InputStream and OutputStream
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read a message from the client
            String message = in.readLine();

            System.out.println("Received: " + message);

            // Send a response back to the client
            out.writeBytes("Hello Client\r\n");
            out.flush();

            socket.close();
            sslServerSocket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}