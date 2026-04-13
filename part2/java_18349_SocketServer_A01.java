import java.net.*;
import javax.net.ssl.*;
import java.io.*;

public class java_18349_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = (SSLSocket) serverSocket.accept();
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new X509KeyManager[]{new MyX509KeyManager()}, new java.security.Provider[] {});

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    out.println("Echo: " + line);
                }

                out.close();
                in.close();
                clientSocket.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}