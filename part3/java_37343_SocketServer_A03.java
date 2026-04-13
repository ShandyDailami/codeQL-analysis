import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37343_SocketServer_A03 {
    private static final String SSL_PORT = "6000";
    private static final String FILE_PATH = "src/main/resources/";

    public static void main(String[] args) {
        runServer();
    }

    private static void runServer() {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            serverSocket = new ServerSocket(Integer.parseInt(SSL_PORT));

            sslServerSocket = (SSLServerSocket) serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            handleClient(inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (sslServerSocket != null) {
                try {
                    sslServerSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(InputStream inputStream, OutputStream outputStream) {
        // Simulating a client that sends a message to the server
        try {
            byte[] bytes = new byte[1024];
            int length = inputStream.read(bytes);
            String message = new String(bytes, 0, length);

            System.out.println("Received message: " + message);

            String response = "Server received your message: " + message;
            outputStream.write(response.getBytes());

            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}