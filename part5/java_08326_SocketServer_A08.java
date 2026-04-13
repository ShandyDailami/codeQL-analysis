import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_08326_SocketServer_A08 {

    private final Socket socket;
    private final SSLServerSocket serverSocket;
    private final SSLContext sslContext;

    public java_08326_SocketServer_A08(int port) throws IOException {
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new String[]{"SSLv3"}, null);

        serverSocket = (SSLServerSocket) sslContext.getServerSocket(port);
        serverSocket.setReuseAddress(true);
        socket = serverSocket.accept();
    }

    public void start() throws IOException {
        OutputStream out = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);

        writer.println("Hello from the server!");

        socket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(8080).start();
    }
}