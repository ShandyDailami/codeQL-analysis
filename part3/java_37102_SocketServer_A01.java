import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_37102_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);

            InputStream is = sslSocket.getInputStream();
            OutputStream os = sslSocket.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            DataOutputStream dos = new DataOutputStream(os);

            String message;
            while ((message = br.readLine()) != null) {
                dos.write(("Server: " + message + "\n").getBytes());
                dos.flush();
            }

            sslSocket.close();
            sslServerSocket.close();
        } finally {
            sslServerSocket.close();
        }
    }
}