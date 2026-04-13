import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_25720_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);

        while (true) {
            socket = sslServerSocket.accept();
            System.out.println("Client Connected");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connection established with " + socket.getInetAddress().getHostAddress());

            SSLSocket sslSocket = (SSLSocket) socket.getNativeSocket();
            sslSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new X509KeyManager[]{new X509KeyManager()}, null);
            sslSocket.setSSLContext(sslContext);

            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            sslSocket.setSSLSocketFactory(sslSocketFactory);

            SSLSession sslSession = sslSocket.getSession();
            sslSession.setReadOnly();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            String str = in.readUTF();
            System.out.println(str);

            socket.close();
        }
    }
}