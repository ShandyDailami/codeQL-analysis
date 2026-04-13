import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_18467_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket sock = null;
        SSLServerSocket serverSock = null;
        SSLContext context = SSLContext.getInstance("SSL");

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKSAPI");
        keyManagerFactory.init(keyStore, "password".toCharArray());

        context.init(keyManagerFactory, null, null);

        sock = new ServerSocket(8080);
        serverSock = (SSLServerSocket) sock;

        while (true) {
            SSLSocket client = (SSLSocket) serverSock.accept();

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                out.println("Echo: " + message);
            }
       
            out.close();
            in.close();
            client.close();
        }
    }
}