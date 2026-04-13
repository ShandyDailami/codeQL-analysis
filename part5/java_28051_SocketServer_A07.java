import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_28051_SocketServer_A07 {
    private static final String SSL_PORT = "12345";

    public static void main(String[] args) throws Exception {
        ServerSocketFactory ssf = (SSLServletContext) new SSLServerSocketFactory(
                new SSLContext(SSLContext.getDefaultSSLContext()),
                new HostnameVerifier() {
                    public boolean verifyServerCertificate(String hostname, SSLServerSocket socket,
                                                           X509Certificate cer) throws IOException {
                        return true;
                    }

                    public boolean validateClientCertificate(String hostname, X509Certificate cert) {
                        return true;
                    }
                });

        ServerSocket serverSocket = (ServerSocket) ssf.createServerSocket(Integer.parseInt(SSL_PORT));
        System.out.println("Server started at port " + SSL_PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Server says: Hello, client!";
            output.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            clientSocket.close();
        }
    }
}