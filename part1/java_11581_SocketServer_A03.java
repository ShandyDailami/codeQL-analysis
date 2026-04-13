import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_11581_SocketServer_A03 {
    private static final String HOST_NAME = "localhost";
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuth(true);

            // Use SSLContext to provide encryption
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new X509Certificate[]{}, null);
            sslServerSocket.setSSLSocketFactory(sslContext.getSocketFactory());

            System.out.println("Server started on port: " + PORT);
            while (true) {
                Socket sock = sslServerSocket.accept();
                System.out.println("Connection accepted from: " + sock.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(sock.getInputStream());
                DataOutputStream out = new DataOutputStream(sock.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Thank you for connecting to " + sock.getRemoteSocketAddress());
                out.flush();
           
                sock.close();
            }
        } finally {
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}