import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.*;

public class java_26982_SocketServer_A07 {
    private static final String PASSWORD = "password";
    private static final String USERNAME = "user";

    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        SSLServerSocket server = null;

        try {
            socket = new ServerSocket(4444);
            server = (SSLServerSocket) socket.accept();

            System.out.println("Connected to client");

            SSLContext context = SSLContext.getInstance("TLSv1.2");
            context.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            server.accept();
            server = (SSLServerSocket) context.getServerSocket();

            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println(message);
            }
        } finally {
            server.close();
            socket.close();
        }
    }

    public static class TrustAllCerts implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {}

        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
    }
}