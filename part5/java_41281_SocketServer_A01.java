import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_41281_SocketServer_A01 {
    private static final String CLIENT_IDENTIFIER = "Client_Identifier";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.setNeedClientAuth(true);

                SSLSession sslSession = sslSocket.getSession();
                if (!sslSession.isValid()) {
                    System.out.println("Invalid session!");
                    continue;
                }

                // Read client message
                BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                String message = reader.readLine();
                System.out.println("Received: " + message);

                // Send back a message to the client
                DataOutputStream writer = new DataOutputStream(sslSocket.getOutputStream());
                writer.writeBytes("Message received: " + message + "\n");
                writer.flush();
            }
        } finally {
            sslServerSocket.close();
        }
    }
}