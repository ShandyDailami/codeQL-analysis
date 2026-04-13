import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_13682_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8001);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new TrustAnyTrustManager()}, null);
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setContext(sslContext);

            while (true) {
                Socket socket = sslServerSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

                String request;
                while ((request = in.readLine()) != null) {
                    processRequest(request, out);
                }

                socket.close();
            }
        } finally {
            sslServerSocket.close();
        }
    }

    private static void processRequest(String request, PrintWriter out) {
        // Simulate injection attempt
        String injectedInput = request + System.lineSeparator() + "BAD_INPUT";
        // Remove SQL injection
        injectedInput = injectedInput.replace(";", "");
        // Remove command injection
        injectedInput = injectedInput.replace("`", "");

        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/plain;charset=utf-8");
        out.println();
        out.println(injectedInput);
    }
}

class TrustAnyTrustManager implements X509TrustManager {
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