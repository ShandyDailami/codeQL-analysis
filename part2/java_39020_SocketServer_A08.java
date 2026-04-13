import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_39020_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = new SSLServerSocket(8080, null, null,
                SSLServerSocket.getDefaultSSLSocketFactory());
        Socket socket = sslServerSocket.accept();

        SSLSocket sslSocket = (SSLSocket) socket;
        SSLContext sslContext = sslSocket.getSSLContext();

        InputStream inputStream = sslSocket.getInputStream();
        OutputStream outputStream = sslSocket.getOutputStream();

        PrintWriter writer = new PrintWriter(outputStream, true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String clientMessage = reader.readLine();
        System.out.println("Client says: " + clientMessage);

        writer.println("Hello, client");
        sslServerSocket.close();
    }
}