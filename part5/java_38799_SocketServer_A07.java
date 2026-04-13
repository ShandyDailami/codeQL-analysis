import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_38799_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                socket = sslServerSocket.accept();

                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress(), socket.getPort());

                sslSocket.startHandshake();

                SSLSession sslSession = sslSocket.getSession();

                OutputStream out = sslSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);

                writer.println("Hello Client, You are connected!");

                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
       
            if (socket != null) {
                socket.close();
            }
        }
    }
}