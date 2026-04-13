import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_27766_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);

            InputStream inputStream = sslSocket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String request = bufferedReader.readLine();
            System.out.println("Received request: " + request);

            if (request.equals("/hello")) {
                PrintWriter printWriter = new PrintWriter(sslSocket.getOutputStream(), true);
                printWriter.println("HTTP/1.1 200 OK");
                printWriter.println("Content-Type: text/plain; charset=utf-8");
                printWriter.println();
                printWriter.println("Hello, World!");
                printWriter.close();
            }

            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }
}