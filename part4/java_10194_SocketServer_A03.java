import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_10194_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;

        try {
            ServerSocket socket = new SSLServerSocket(new InetSocketAddress(port), null, null, SSLServerSocket.CipherSuite.DEFAULT);
            SSLSocket client = (SSLSocket) socket.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hello, client!");
            client.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}