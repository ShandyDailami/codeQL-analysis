import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_04670_SocketServer_A07 {
    private static final String CLIENT_KEYSTORE_LOCATION = "/path/to/client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "clientkeystorepassword";
    private static final String SERVER_KEYSTORE_LOCATION = "/path/to/server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "serverkeystorepassword";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            KeyStore clientkeystore = KeyStore.getInstance("JKS");
            clientkeystore.load(new FileInputStream(CLIENT_KEYSTORE_LOCATION), CLIENT_KEYSTORE_PASSWORD.toCharArray());

            KeyStore serverkeystore = KeyStore.getInstance("JKS");
            serverkeystore.load(new FileInputStream(SERVER_KEYSTORE_LOCATION), SERVER_KEYSTORE_PASSWORD.toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(clientkeystore, new String[] { SERVER_KEYSTORE_PASSWORD }, new java.security.SecureRandom());

            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) sslContext.wrapSocket(socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());
                System.out.println("Connection established");

                // communication with client
                String strRequest;
                while ((strRequest = in.readLine()) != null) {
                    System.out.println("Received: " + strRequest);
                    out.write(("Server Received: " + strRequest).getBytes());
                    out.newLine();
                    out.flush();
                }
            }
        } finally {
            serverSocket.close();
        }
    }
}