import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_16252_SocketServer_A01 {
    private static final String HOST_NAME = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            while (true) {
                socket = serverSocket.accept();

                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress(), socket.getLocalPort());
                sslSocket.setNeedClientAuthentication(true);
                sslSocket.startHandshake();

                System.out.println("Client connected: " + sslSocket.getRemoteSocketAddress());

                // Perform operations related to access control here, e.g.
                // sslSocket.setEnabledProtocols(sslSocket.getSupportedProtocols());
                // sslSocket.setRequestedProtocols(sslSocket.getDefaultRequestedProtocols());

                BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(sslSocket.getOutputStream());

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Server received: " + line);

                    // Send back the received message
                    writer.write((line + "\r\n").getBytes());
                    writer.flush();
                }

                sslSocket.close();
            }
        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
       
            if (socket != null) {
                socket.close();
            }
        }
    }
}