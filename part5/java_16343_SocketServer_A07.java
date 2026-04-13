import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_16343_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080);
            Socket sslSocket = sslServerSocket.accept();
            System.out.println("Connection from " + sslSocket.getRemoteSocketAddress());

            InputStream inputStream = sslSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = sslSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            String clientInput;
            while ((clientInput = reader.readLine()) != null) {
                System.out.println("Received: " + clientInput);
                writer.println("Hello, " + clientInput);
            }
            sslServerSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}