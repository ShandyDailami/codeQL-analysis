import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_17432_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            ServerSocket sslServerSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(5000);

            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                // Here is where you handle the socket.
                // For example, you could start a new thread to handle the socket.
                new HandleSocketThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleSocketThread extends Thread {

    private Socket socket;

    public java_17432_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here is where you handle the socket.
        // For example, you could read from the socket, send a response, etc.
    }
}