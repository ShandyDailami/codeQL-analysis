import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_23273_SocketServer_A03 {
    private static final String CLIENT_STRING = "CLIENT";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, null);
            serverSocket.setSSLContext(sslContext);
            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.getTransportSocket();
                System.out.println("Client Connected");
                new SSLInput(sslSocket, CLIENT_STRING).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class SSLInput extends Thread {
        private final Socket socket;
        private final String checkString;

        public java_23273_SocketServer_A03(Socket socket, String checkString) {
            this.socket = socket;
            this.checkString = checkString;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(checkString)) {
                        System.out.println("String Contained");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class TrustAnyTrustManager implements X509TrustManager {
        public boolean checkClientTrusted(X509Certificate[] chain, String authType) {
            return true;
        }

        public boolean checkServerTrusted(X509Certificate[] chain, String authType) {
            return true;
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}