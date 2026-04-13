import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_31613_SocketServer_A03 {
    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            // Create an SSLServerSocket using SSLSocketFactory
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);

            // Enable SSL
            serverSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new X509KeyManager[]{new KeyManager()}, new java.security.Provider() {
                @Override
                public Object findAlgorithm(String s, Type type) {
                    return null;
                }
            });

            serverSocket.setSSLContext(sslContext);

            // Accept incoming connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established from " + clientSocket.getRemoteSocketAddress());
                OutputStream out = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("HTTP/1.1 200 OK");
                writer.println("Content-Type: text/plain; charset=utf-8");
                writer.println();
                writer.println("Hello, this is a test for SocketServer!");
                writer.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) {}
            }
        }
    }
}