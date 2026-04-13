import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_00934_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444);
        sslServerSocket.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, new java.security.SecureRandom());
        SSLSocket socket = (SSLSocket) sslServerSocket.accept();
        socket.setEnabled(true);
        socket.setUseClientMode(true);
        socket.setSSLSocket(socket);
        socket.setSSLContext(sslContext);
        OutputStream out = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);
        writer.println("Hello from SocketServer!");
        socket.close();
    }
}