import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_36934_SocketServer_A03 {
    private static final String SSL_PORT = "1234";
    private static final String NORMAL_PORT = "12345";
    private static ServerSocket normalServerSocket;
    private static SSLServerSocket sslServerSocket;

    public static void main(String[] args) {
        try {
            System.out.println("Starting normal server");
            normalServerSocket = new ServerSocket(Integer.parseInt(NORMAL_PORT));
            startServer(normalServerSocket);

            System.out.println("Starting SSL server");
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(Integer.parseInt(SSL_PORT));
            sslServerSocket.setNeedClientAuth(true); // SSL Server requires client authentication
            startServer(sslServerSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startServer(ServerSocket serverSocket) {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                SSLSocket sslSocket = (SSLSocket) socket.getChannel().accept();
                System.out.println("Client connected using SSL");

                // Here is where the code will be to handle the received messages

                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}