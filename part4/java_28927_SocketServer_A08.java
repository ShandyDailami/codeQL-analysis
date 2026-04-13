import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_28927_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            serverSocket.setSSLContext(sslContext);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        Socket socket = null;
        try {
            socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String message;
            while ((message = in.readLine()) != null) {
                out.writeBytes(message + "\n");
            }
        } finally {
            socket.close();
            serverSocket.close();
        }
    }
}