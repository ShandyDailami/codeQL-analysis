import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_02080_SocketServer_A01 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server...");
        ServerSocket socket = new ServerSocket(4444);
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) socket.getServerSocketFactory();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444);
        serverSocket.setNeedClientAuthentication(true);

        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null, new TrustManager[] { new TrustAllCerts() }, new java.security.SecureRandom());
        HSSFSServerSocketImpl server = (HSSFSServerSocketImpl) context.getServerSocketFactory().createServerSocket(4444);
        server.setNeedClientAuthentication(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) server.accept();
            System.out.println("Client connected!");
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("Hello client, you are connected!");
        }
    }
}