import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_37496_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(1234);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setContext(sslContext);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected!");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Write a simple response
                out.writeUTF("Hello, Client!");
                out.flush();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}