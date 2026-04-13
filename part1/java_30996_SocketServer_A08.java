import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_30996_SocketServer_A08 {
    private static final int PORT = 443;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new X509TrustManager() }, null);
            sslServerSocket.setSSLContext(sslContext);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            Socket socket = null;
            try {
                socket = sslServerSocket.accept();
            } catch (SocketException e) {
                e.printStackTrace();
                continue;
            }

            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
           
            // write the response to the client
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                bw.write("HTTP/1.1 200 OK\r\n");
                bw.write("Content-Type: text/plain; charset=utf-8\r\n");
                bw.write("\r\n");
                bw.write("Hello, client!");
                bw.write("\r\n");
            }

            socket.close();
        }
    }
}