import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_23970_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            // Create SSLServerSocket to listen on port 12345 with the key store
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, null, null, SSLServerSocket.getDefaultCipherSuite());
            sslServerSocket.setNeedClientAuth(true);
            // Setup handshake and send the client a challenge
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
            // Perform handshake
            sslSocket.startHandshake();
            // Check if the handshake was successful
            if (sslSocket.getState() != SSLSocket.CLOSE_WAIT) {
                throw new IOException("Unexpected state: " + sslSocket.getState());
            }
        } catch (SSLException e) {
            e.printStackTrace();
        }

        // Now we can write data to the socket
        BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        DataOutputStream writer = new DataOutputStream(sslSocket.getOutputStream());

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Server received: " + line);
            writer.write((line + "\n").getBytes());
        }

        sslSocket.close();
    }
}