import java.io.*;
import java.net.*;
import java.security.cert.*;
import javax.net.ssl.*;

public class java_31734_SocketServer_A01 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        try {
            // Set up SSLContext with a KeyStore
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT);
            sslServerSocket.setNeedClientAuthentication(true);
            sslServerSocket.setSocketOptions(SocketOption.TCP_NODELAY, true);
            sslServerSocket.setEnabledProtocols(new String[] {"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});

            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(keyStore, null, new java.security.cert.Certificate[]{});
            sslServerSocket.setSSLContext(sslContext);

            // Create Socket
            Socket socket = sslServerSocket.accept();
            socket.setSoTimeout(60000);

            // Input/Output Streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read request
            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            // Send response
            dos.writeUTF("Hello, client, your data has been successfully processed!");
            dos.flush();

            // Close connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}