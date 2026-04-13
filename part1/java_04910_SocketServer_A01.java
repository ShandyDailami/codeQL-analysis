import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_04910_SocketServer_A01 {
    private static final int PORT = 8080;
    private static SSLServerSocket sslServerSocket;
    private static Socket socket;
    private static BufferedReader in = null;
    private static PrintWriter out = null;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        sslServerSocket.setNeedClientAuth(true);

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
        sslServerSocket.setSSLContext(sslContext);

        while (true) {
            socket = sslServerSocket.accept();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Thank you for connecting");
            }
       
            sslServerSocket.close();
        }
    }
}