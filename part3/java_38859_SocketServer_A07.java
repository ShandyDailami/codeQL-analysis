import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_38859_SocketServer_A07 {

    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            sslServerSocket.setSSLContext(sslContext);

            while (true) {
                Socket socket = sslServerSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.getNativeSocket();
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

                String client = in.readLine();
                if ("exit".equals(client)) {
                    break;
                }

                String user = client.split(" ")[0];
                String pass = client.split(" ")[1];

                if (!USERNAME.equals(user) || !PASSWORD.equals(pass)) {
                    out.println("unauthorized");
                    out.flush();
                    continue;
                }

                out.println("authorized");
                out.flush();
            }
        } finally {
            sslServerSocket.close();
        }
    }

    private static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }
        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
    }
}