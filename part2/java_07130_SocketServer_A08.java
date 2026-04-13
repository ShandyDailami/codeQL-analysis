import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_07130_SocketServer_A08 {
    private static final int PORT = 8888;

    public static void main(String[] args) {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.setNeedClientAuth(true);

                SSLSession sslSession = sslSocket.getSession();
                sslSession.setWantClientAuth(true);

                InputStream inputStream = sslSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                OutputStream outputStream = sslSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println("Hello World");

                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}