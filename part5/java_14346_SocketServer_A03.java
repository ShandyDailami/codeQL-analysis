import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_14346_SocketServer_A03 {

    private SSLServerSocket sslServerSocket;
    private ServerSocket serverSocket;
    private boolean ssl = true;
    private boolean startServer = true;

    public java_14346_SocketServer_A03() throws IOException {
        if (ssl) {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(12345);
        } else {
            serverSocket = new ServerSocket(12345);
        }
    }

    public void start() {
        while (startServer) {
            if (ssl) {
                try {
                    SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                    handleSSLConnection(sslSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Socket socket = serverSocket.accept();
                    handleConnection(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleSSLConnection(SSLSocket socket) throws IOException {
        // Handling SSL connection...
    }

    private void handleConnection(Socket socket) throws IOException {
        Scanner scanner = new Scanner(socket.getInputStream());
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            // Handling command...
        }
    }

    public static void main(String[] args) {
        try {
            SecureSocketServer server = new SecureSocketServer();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}