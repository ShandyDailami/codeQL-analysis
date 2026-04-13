import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class java_14872_SocketServer_A07 {

    private SSLServerSocket serverSocket;
    private SSLSocket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public void startServer(int port) {
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(port);
            System.out.println("Server started on port: " + port);

            // Wait for client connection
            socket = serverSocket.accept();

            // Enable client to send and receive data
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            String response = "Hello, Client!";
            outputStream.write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }

            if (socket != null) {
                socket.close();
            }
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        server.startServer(8080);
    }
}