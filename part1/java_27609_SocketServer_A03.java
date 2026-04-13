import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_27609_SocketServer_A03 {
    private static final String PASSWORD = "password";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(9001);

        serverSocket.setNeedClientAuth(true);
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), PASSWORD.toCharArray());
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, null, null);
        serverSocket.setSSLContext(sslContext);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
            sslSocket.setNeedClientAuth(true);

            System.out.println("Client connected");
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(sslSocket.getOutputStream());

            String userInput = reader.readLine();

            if (userInput.equals(PASSWORD)) {
                writer.write("Authorized".getBytes());
            } else {
                writer.write("Access denied".getBytes());
            }

            writer.close();
            clientSocket.close();
        }
    }
}