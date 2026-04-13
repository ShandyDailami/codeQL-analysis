import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_40251_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444, null, null,
                    SSLServerSocketInit.builder().setKeyStore(new File("server.jks"), "123456789".toCharArray()).setCipherSuites(SslContext.DEFAULT_CIPHER_SUITES).build());

            System.out.println("Listening for client connections...");
            SSLSocket clientSocket = sslServerSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.writeBytes("Hello, client\n");
            }

            clientSocket.close();

        } catch (SSLException e) {
            e.printStackTrace();
        }
    }
}