import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_18171_SocketServer_A03 {
    private static SSLServerSocket serverSocket;
    private static SSLSocket socket;
    private static InputStream inputStream;
    private static OutputStream outputStream;
    private static SSLContext sslContext;

    public static void main(String[] args) {
        try {
            // Create a SSL context
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, null, null);

            // Create a server socket
            serverSocket = (SSLServerSocket) sslContext.getServerSocket(4444);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                // Accept a client connection
                socket = (SSLSocket) serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();

                // Write a message to the client
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                out.println("Hello from the server!");

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}