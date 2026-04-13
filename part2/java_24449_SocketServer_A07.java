import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_24449_SocketServer_A07 {
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            serverSocket.setNeedClientAuthentication(true);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new X509Certificate[] { /* get certificate from certificate store here */ }, null);

            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) sslContext.wrapSocket(socket);

                OutputStream out = sslSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello Client, you are now connected to the secure server!");

                System.out.println("Accepted new connection from: " + sslSocket.getRemoteSocketAddress());

                SSLSocket client = (SSLSocket) sslServerSocketFactory.createContext(sslSocket);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}