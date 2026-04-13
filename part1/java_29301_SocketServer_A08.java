import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;
import javax.net.ssl.SSLSocket;

public class java_29301_SocketServer_A08 {

    private static ExecutorService executorService;
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        executorService = Executors.newCachedThreadPool();
        ServerSocketFactory socketFactory = (ServerSocketFactory) SSLServerSocket.getDefault().getProtocol().getDefaultSocketFactory();
        serverSocket = (SSLServerSocket) socketFactory.createServerSocket(8080);
        serverSocket.setNeedClientAuthentication(true);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustManager() }, null);
        serverSocket.setSSLContext(sslContext);
        while (true) {
            final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        InputStream inputStream = clientSocket.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        String message;
                        while ((message = reader.readLine()) != null) {
                            System.out.println("Received: " + message);
                            clientSocket.getOutputStream().write((message + "\n").getBytes());
                            clientSocket.getOutputStream().flush();
                        }
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    // Inner class to implement SSL TrustManager
    private static class TrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException { }
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException { }
        public X509Certificate[] getAcceptedIssuers() { return null; }
    }
}