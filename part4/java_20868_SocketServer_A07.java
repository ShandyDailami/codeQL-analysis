import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_20868_SocketServer_A07 {
    private static SSLServerSocket serverSocket;
    private static SSLSocket clientSocket;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
        serverSocket.setNeedClientAuth(true);

        while (true) {
            clientSocket = serverSocket.accept();
            clientSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new KeyStorePasswordCallback());
            clientSocket.setSSLContext(sslContext);

            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                clientSocket.getOutputStream().write(("Echo: " + message).getBytes());
                clientSocket.getOutputStream().flush();
            }
            clientSocket.close();
        }
    }

    private static class TrustAnyTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
    }

    private static class KeyStorePasswordCallback implements KeyStorePasswordCallback {
        public String getPassword(String arg0, String arg1, String arg2, char[] arg3) {
            return "secure";
        }
    }
}