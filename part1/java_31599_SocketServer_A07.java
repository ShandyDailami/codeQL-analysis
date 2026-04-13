import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_31599_SocketServer_A07 {
    private static final String CLIENT_IDENTIFIER = "Client_Identifier";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                socket = (SSLSocket) serverSocket.accept();
                socket.setNeedClientAuthentication(true);
                socket.setEnabledCipherSuites(socket.getSupportedCipherSuites());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String clientIdentifier = in.readLine();
                if (clientIdentifier.equals(CLIENT_IDENTIFIER)) {
                    out.println("Authentication successful. Connection accepted.");
                    out.flush();
                } else {
                    out.println("Authentication failed.");
                    out.flush();
                    socket.close();
                    continue;
                }

                // start processing the request
                // ...

                in.close();
                out.close();
                socket.close();
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (socket != null) socket.close();
        }
    }
}