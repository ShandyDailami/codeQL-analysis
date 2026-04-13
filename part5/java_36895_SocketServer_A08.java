import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36895_SocketServer_A08 {
    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            KeyStore clientkeystore = KeyStore.getInstance("JKS");
            clientkeystore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());

            KeyStore serverkeystore = KeyStore.getInstance("JKS");
            serverkeystore.load(new FileInputStream(SERVER_KEYSTORE), SERVER_KEYSTORE_PASSWORD.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444, null, clientkeystore, serverkeystore);
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Connection accepted from: " + socket.getRemoteSocketAddress());

                SSLSocket sslSocket = (SSLSocket) socket.getDefaultSSLSocket();

                InputStream input = sslSocket.getInputStream();
                OutputStream output = sslSocket.getOutputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                DataOutputStream out = new DataOutputStream(output);

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Server received: " + line);
                    out.writeBytes(line + "\n");
                }
           
            }
        } finally {
            sslServerSocket.close();
        }
    }
}