import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_26078_SocketServer_A03 {
    private static final String PASSWORD = "secure";

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(4444);
        SSLServerSocket sslServerSocket = (SSLServerSocket) socket.accept();

        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new TrustManager[] { new TrustManagerSSL() }, null);

        sslServerSocket.setNeedClientAuth(true);
        sslServerSocket.setEnabledCipherSuites(new String[] { "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256" });

        SSLSocket sslSocket = (SSLSocket) context.wrapSocket(sslServerSocket);
        sslSocket.startHandshake();

        if (sslSocket.getRemoteCertificate().getCertificate().getExtension(X509Certificate.EXTENSION_REASON_UNSUPPORTED_EXTENSION) != null) {
            System.out.println("Unsupported extension!");
        } else {
            System.out.println("Supported extension!");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        out.println("Hello from server!");
        String message = in.readLine();
        System.out.println("Client says: " + message);

        sslSocket.close();
    }
}