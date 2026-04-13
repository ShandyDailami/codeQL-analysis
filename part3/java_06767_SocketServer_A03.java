import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06767_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        SSLServerSocket sslServer = (SSLServerSocket) server.accept();
        Socket socket = sslServer.accept();

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
        sslServer = (SSLServerSocket) sslContext.getServerSocketFactory().createServerSocket(4444);

        SSLSocket sslSocket = (SSLSocket) sslServer.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        String message = in.readLine();
        out.println("Server received: " + message);

        sslSocket.close();
        server.close();
    }
}