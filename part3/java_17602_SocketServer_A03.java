import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_17602_SocketServer_A03 {

    private static final String CLIENT_HELLO = "Hello from client, I'm your connection ID";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustAnyCerts() }, null);

        serverSocket = (SSLServerSocket) sslContext.getServerSocket(8080);
        serverSocket.setNeedClientAuth(true);

        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

        while (true) {
            socket = (SSLSocket) serverSocket.accept();
            socket.setNeedClientAuth(true);

            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);

            writer.println(CLIENT_HELLO);
            writer.flush();

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String serverResponse;
            while ((serverResponse = reader.readLine()) != null) {
                System.out.println("Server: " + serverResponse);
            }
        }
    }

    static class TrustAnyCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            // Ignore client certificate for now
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            // Ignore server certificate for now
        }
    }
}