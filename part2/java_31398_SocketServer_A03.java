import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_31398_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setEnabledProtocols(new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});

            System.out.println("Waiting for client connection on port 12345...");

            SSLSocket sslSocket = null;
            BufferedReader in = null;
            DataOutputStream out = null;
            while (true) {
                sslSocket = sslServerSocket.accept();
                sslSocket.setNeedClientAuth(true);

                in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                out = new DataOutputStream(sslSocket.getOutputStream());

                String clientMsg;
                while ((clientMsg = in.readLine()) != null) {
                    System.out.println("Client: " + clientMsg);

                    // Here we can insert our own logic for the injection.
                    // For example, here we'll just echo back the client's message
                    String serverMsg = clientMsg;

                    out.writeBytes("Server: " + serverMsg + "\n");
                    out.flush();
                }
            }
        } finally {
            sslServerSocket.close();
        }
    }
}