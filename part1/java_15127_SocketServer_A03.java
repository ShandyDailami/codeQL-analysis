import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.*;

public class java_15127_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            serverSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/server.jks"), "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, null);
            serverSocket.setSSLContext(sslContext);

            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                new EchoHandler(clientSocket).start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}

class EchoHandler extends Thread {
    private final Socket socket;

    public java_15127_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (socket;
            SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getChannel().getRemoteAddress())) {

            sslSocket.setNeedClientAuth(true);

            SSLParameters sslParameters = new SSLParameters();
            sslParameters.setSSLMode(SSLParameters.SSLv2_CLIENT_AUTH);
            sslSocket.setSSLParameters(sslParameters);

            sslSocket.setEnabledProtocols(new String[] { SSLParameters.TLSv1_2_CLIENT_AUTH_METHOD });

            System.out.println("Handshake complete. SSL version: " + sslSocket.getProtocol());

            byte[] bytes = new byte[1024];
            int bytesRead;
            while ((bytesRead = sslSocket.getInputStream().read(bytes)) != -1) {
                sslSocket.getOutputStream().write(bytes, 0, bytesRead);
                sslSocket.getOutputStream().flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}