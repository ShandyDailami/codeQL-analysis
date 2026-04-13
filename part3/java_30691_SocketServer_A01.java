import java.net.*;
import javax.net.ssl.*;
import java.io.*;

public class java_30691_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocketFactory factory = (ServerSocketFactory) SSLServerSocket.getDefault().getProtocol();
        SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(1234);

        // Enable server to accept client requests using SSL
        serverSocket.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, new java.security.SecureRandom());
        serverSocket.setSSLContext(sslContext);

        while (true) {
            Socket socket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();

            // Setup a buffered reader and writer
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(sslSocket.getOutputStream());

            // Ask for client certificate
            writer.writeBytes("GET / HTTP/1.1\r\nHost: localhost\r\n\r\n");
            writer.flush();

            String resp = reader.readLine();
            System.out.println(resp);
            socket.close();
        }
    }
}