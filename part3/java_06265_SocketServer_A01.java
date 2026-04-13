import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_06265_SocketServer_A01 {

    private static SSLServerSocket serverSocket;
    private static BufferedReader reader;
    private static PrintWriter writer;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new X509TrustManager() }, null);
            serverSocket.setSSLContext(sslContext);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);
                    // handle request

                    writer.println("HTTP/1.1 200 OK");
                    writer.println("Content-Type: text/plain; charset=utf-8");
                    writer.println();
                    writer.println("Hello, Client!");
                    writer.flush();
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}