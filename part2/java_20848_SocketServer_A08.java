import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_20848_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        Socket socket = sslServerSocketFactory.createSocket(InetAddress.getByName("localhost"), 8888);
        SSLServerSocket serverSocket = (SSLServerSocket) socket.getSocket();
        serverSocket.setNeedClientAuth(true);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

        // Client authentication
        SSLSession session = serverSocket.accept();
        SSLCertificate cert = session.getPeerCertificate();

        // Send server certificate
        writer.write((new String("Server certificate: " + cert.toString() + "\r\n")).getBytes());
        writer.flush();

        // Close connection
        reader.close();
        writer.close();
        serverSocket.close();
    }
}