import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_10603_SocketServer_A07 {
    private static final String CLIENT_IDENTITY = "Client";
    private static final String CHALLENGE = "To receive a 1010 certificate, please type '1010' followed by a line break.";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000, 1000, true);
        serverSocket.setReuseAddress(true);
        SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket;
        sslServerSocket.setNeedClientAuthentication(true);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustManager() }, null);
        sslServerSocket.setSSLContext(sslContext);

        while (true) {
            Socket clientSocket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) clientSocket;

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

            String clientInput = in.readLine();
            if (clientInput.equals("1010")) {
                out.println(CLIENT_IDENTITY);
                out.flush();

                String response = in.readLine();
                if (!response.equals(CHALLENGE)) {
                    System.out.println("Invalid response: " + response);
                    continue;
                }

                out.println("200 OK");
                out.flush();
            } else {
                out.println("400 Bad Request");
                out.flush();
            }

            clientSocket.close();
        }
    }

    private static class TrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isTrusted(X509Certificate[] chain) {
            return true;
        }
    }
}