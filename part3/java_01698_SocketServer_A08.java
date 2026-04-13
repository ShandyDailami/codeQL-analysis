import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_01698_SocketServer_A08 {
    public static void main(String[] args) {
        boolean useSSL = false;

        if (useSSL) {
            SSLServerSocket serverSocket = null;
            try {
                serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
                System.out.println("Server is listening on port 8080");

                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client connected");
                    SSLSocket sslSocket = (SSLSocket) socket.accept();
                    System.out.println("SSL Client connected");
                    // Handle sslSocket here
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            }
        } else {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(8080);
                System.out.println("Server is listening on port 8080");

                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client connected");
                    // Handle socket here
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            }
        }
    }
}