import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_03774_SocketServer_A03 {
    private static final String SSL_PORT = "12345";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        System.out.println("Starting server...");

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
            serverSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            System.out.println("Failed to create SSL ServerSocket: " + e.getMessage());
            System.exit(1);
        }

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());

                SSLSocket sslSocket = (SSLSocket) clientSocket.getChannel().accept();

                SSLInputStream sslIn = new SSLInputStream(sslSocket.getInputStream());
                SSLOutputStream sslOut = new SSLOutputStream(sslSocket.getOutputStream());

                sslOut.setNeedClientAuth(true);
                sslOut.setEnabledProtocols(new String[]{"TLSv1"});
                sslOut.setNeedClientCert(true);

                // Input validation
                DataInputStream in = new DataInputStream(sslIn);
                String message = in.readUTF();
                if (message.equals("exit")) {
                    sslOut.close();
                    clientSocket.close();
                } else {
                    sslOut.write("Received: " + message);
                    sslOut.flush();
                }

            } catch (IOException e) {
                System.out.println("Error in communication: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}