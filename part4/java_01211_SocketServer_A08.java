import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_01211_SocketServer_A08 {

    private static final String CLIENT_KEY = "src/main/resources/client.key";
    private static final String CLIENT_CERT = "src/main/resources/client.crt";
    private static final String CA_CERT = "src/main/resources/ca.crt";

    public static void main(String[] args) {

        SSLServerSocket serverSocket = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("src/main/resources/keystore.jks"), "password".toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream("src/main/resources/truststore.jks"), "password".toCharArray());

            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080,
                    (SSLSocket) null,
                    keyStore,
                    trustStore);

            serverSocket.setNeedClientAuth(true);

            SSLSocket socket = (SSLSocket) serverSocket.accept();

            socket.setNeedClientAuth(true);

            SSLSession session = socket.getSession();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            writer.writeBytes("Hello client, you are connected to SSL Server\n");
            writer.flush();

            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("Server: " + line);
            }

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}