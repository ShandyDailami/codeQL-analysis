import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_16614_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuthentication(true);
            serverSocket.setCertificateTrustStore(new File("truststore.jks"));

            while (true) {
                socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.getWrappedSocket();

                System.out.println("Client " + sslSocket.getRemoteSocketAddress() + " connected");

                DataInputStream in = new DataInputStream(sslSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

                // Send data
                out.writeUTF("Hello client, you are now connected to " + sslSocket.getRemoteSocketAddress() + "!");
                out.flush();

                // Receive data
                String message = in.readUTF();
                System.out.println("Message from client: " + message);

                sslSocket.close();
           
            }
        } finally {
            serverSocket.close();
        }
    }
}