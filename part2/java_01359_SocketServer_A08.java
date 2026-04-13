import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_01359_SocketServer_A08 {
    public static void main(String[] args) {
        boolean isSecure = true;

        if (isSecure) {
            try {
                SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
                handleClient(serverSocket.accept());
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                handleClient(serverSocket.accept());
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleClient(Socket socket) {
        try {
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setNeedClientAuth(true);
            sslSocket.startHandshake();

            if (!sslSocket.getSession().isValid()) {
                System.out.println("Invalid SSL Session, closing connection");
                socket.close();
            } else {
                System.out.println("Handshake succeeded");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}