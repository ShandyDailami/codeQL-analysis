import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_13639_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket sock = new ServerSocket(4444, 128, InetAddress.getByName("localhost"));
        sock.setReuseAddress(true);
        SSLServerSocket serverSock = (SSLServerSocket) sock;
        serverSock.setNeedClientAuthentication(true);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new TrustAllCertificates()}, new java.security.SecureRandom());

        SSLSocket socket = (SSLSocket) sslContext.getSocketSink();

        while (true) {
            System.out.println("Waiting for connection...");
            SSLSocket clientSocket = serverSock.accept();
            System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

            OutputStream out = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello Client, you are connected to SSL Server");

            InputStream in = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String message = reader.readLine();
            System.out.println("Message from Client: " + message);

            clientSocket.close();
        }
    }
}