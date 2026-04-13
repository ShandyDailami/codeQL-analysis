import javax.net.ssl.*;
import java.net.*;
import java.io.*;

public class java_10974_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8001);
            sslServerSocket.setNeedClientAuthentication(true);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Client connected");

                SSLInputStream sslIn = new SSLInputStream(sslSocket.getInputStream());
                SSLOutputStream sslOut = new SSLOutputStream(sslSocket.getOutputStream());

                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new X509KeyManager[] { new X509KeyManager() }, null);
                sslIn = new SSLInputStream(sslSocket.getInputStream());
                sslOut = new SSLOutputStream(sslSocket.getOutputStream());

                sslOut.write("HTTP/1.1 200 OK\r\n".getBytes());
                sslOut.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
                sslOut.write("\r\n".getBytes());
                sslOut.flush();

                sslContext.getSession().doHandshake();

                // read from the socket and write to the output stream
                BufferedReader br = new BufferedReader(new InputStreamReader(sslIn));
                String line = br.readLine();
                while (line != null) {
                    System.out.println("Received: " + line);
                    sslOut.write((line + "\r\n").getBytes());
                    line = br.readLine();
                }
                sslOut.close();
            }
        } finally {
            if (sslServerSocket != null)
                sslServerSocket.close();
        }
    }
}