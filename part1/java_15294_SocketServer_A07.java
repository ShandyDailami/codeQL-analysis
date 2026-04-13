import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_15294_SocketServer_A07 {
    private static final String SSL_PORT = "443";
    private static final String SERVER_SOFTWARE = "Java Secure SocketServer";
    private static final String SSL_KEYSTORE_FILE = "server.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocketFactory ssrf = (SSL_PORT.equals("443") ? SSLServerSocketFactory.getDefault() : SSLServerSocketFactory.getDefault());
        SSLServerSocket sslServerSocket = null;

        if (SSL_PORT.equals("443")) {
            SSLServerSocket sslServerSocket = (SSLServerSocket) ssrf.createServerSocket(Integer.parseInt(SSL_PORT));
            sslServerSocket.setNeedClientAuthentication(true);
        }

        while (true) {
            Socket socket = sslServerSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String request, response;
            while ((request = in.readLine()) != null) {
                out.println(request);

                if (SSL_PORT.equals("443")) {
                    String clientPass = in.readLine();
                    if (!clientPass.equals(SSL_KEYSTORE_PASSWORD)) {
                        out.println("A07_AuthFailure");
                        out.flush();
                        continue;
                    }
                }

                // handle the request here...
                // for example, we'll just respond with the request

                response = "Server: " + request;
                out.println(response);
                out.flush();
            }
        }
    }
}