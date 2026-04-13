import javax.net.ssl.*;
import java.net.*;
import java.io.*;

public class java_28027_SocketServer_A01 {

    private final int port;
    private SSLServerSocket serverSocket;
    private SSLSocket clientSocket;
    private final SSLContext sslContext;

    public java_28027_SocketServer_A01(int port) throws Exception {
        this.port = port;
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
    }

    public void start() throws Exception {
        serverSocket = (SSLServerSocket) sslContext.getServerSocket(port);
        serverSocket.setNeedClientAuth(true);

        System.out.println("Server started on port " + port + ", waiting for client connection...");

        clientSocket = serverSocket.accept();
        System.out.println("Client accepted");
    }

    public void handle() throws Exception {
        InputStream input = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Received: " + line);
        }

        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) {
        try {
            new SocketServer(8080).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}