import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_01535_SocketServer_A08 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        SSLServerSocket socket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            socket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            socket.setNeedClientAuth(true);
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());
            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(keyStore, null, new TrustManager[] { new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            } });
            socket.setSSLSocketFactory(sslContext.getSocketFactory());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                SSLSocket clientSocket = (SSLSocket) socket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}