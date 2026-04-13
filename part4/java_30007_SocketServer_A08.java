import javax.net.ssl.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30007_SocketServer_A08 {

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        Socket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            socket = serverSocket.accept();

            HSSFWriter writer = new HSSFWriter(socket.getOutputStream());
            writer.write("HTTP/1.1 200 OK\r\n");
            writer.write("Content-Type: text/html; charset=utf-8\r\n");
            writer.write("Set-Cookie: session=1234567890\r\n");
            writer.write("\r\n");

            // Here is where you can add your business logic
            // Example: read and write data
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello, client!".getBytes());
            socket.close();

        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}