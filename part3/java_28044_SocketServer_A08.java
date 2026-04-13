import javax.net.ssl.*;
import java.net.*;
import java.io.*;

public class java_28044_SocketServer_A08 {
    private static final String CLIENT_HELLO_MESSAGE = "Client Hello";
    private static final String SERVER_HELLO_MESSAGE = "Server Hello";
    private static final int PORT = 5000;

    public static void main(String[] args) throws Exception {
        ServerSocket sock = null;
        SSLServerSocket secureSock = null;
        try {
            sock = new ServerSocket(PORT);
            SSLServerSocketFactory sslSockFactory = (SSLServerSocketFactory) sock.getInetAddress().getCanonicalHostName();
            secureSock = (SSLServerSocket) sslSockFactory.createServerSocket(PORT, 5000, null, null);
        } catch (IOException e) {
            e.printStackTrace();
       
        }
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new TrustManager[]{new TrustAllCerts()}, new java.security.SecureRandom());
        secureSock.accept();
        try {
            Socket socket = secureSock.accept();
            socket.setSoTimeout(60000);
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setEnabled(true);
            OutputStream out = sslSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            InputStream in = sslSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println("Client: " + str);
                writer.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (secureSock != null) {
                secureSock.close();
            }
            if (sock != null) {
                sock.close();
            }
        }
    }

    static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            return;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            return;
        }
    }
}