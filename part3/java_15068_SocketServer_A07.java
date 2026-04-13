import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class java_15068_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080,
                    null, InetAddress.getByName("localhost"));
            System.out.println("Waiting for client connection...");
            socket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int length;
            while ((length = input.read(bytes)) != -1) {
                output.write(bytes, 0, length);
                output.flush();
            }
        } finally {
            if (socket != null) socket.close();
            if (serverSocket != null) serverSocket.close();
        }
    }
}