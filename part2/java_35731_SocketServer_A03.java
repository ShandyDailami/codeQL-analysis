import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_35731_SocketServer_A03 {
    private static SSLServerSocket sslServerSocket = null;
    private static DataInputStream dis = null;
    private static DataOutputStream dos = null;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444);
        sslServerSocket.setNeedClientAuthentication(true);

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new X509KeyManager[] { new X509KeyManager() }, null);
        sslServerSocket.setSSLContext(sslContext);

        System.out.println("Waiting for client on port " + 4444);

        Socket socket = sslServerSocket.accept();
        System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

        sslServerSocket.setNeedClientAuthentication(false);

        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());

        String request = dis.readUTF();
        System.out.println("Received: " + request);

        dos.writeUTF("Thank you for connecting, " + socket.getRemoteSocketAddress() + "\n");
        dos.flush();

        socket.close();
    }
}