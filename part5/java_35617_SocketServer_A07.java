import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;

public class java_35617_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null, null, null); // use no key pair and no protection

        SSLServerSocket serverSocket = (SSLServerSocket) context.getServerSocket(8080);
        serverSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket socket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");
            // handle client connection
        }
    }
}