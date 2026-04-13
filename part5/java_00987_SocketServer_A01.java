import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_00987_SocketServer_A01 {

    public static void main(String[] args) {
        // Create a SSLServerSocket
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Accept SSL connections
        Socket socket = null;
        try {
            socket = sslServerSocket.accept();
            System.out.println("Client Connected: " + socket.getInetAddress().getHostAddress());

            // Create an SSLSocket
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setNeedClientAuth(true);

            // Read data from the SSLSocket
            InputStream inputStream = sslSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String data;
            while ((data = reader.readLine()) != null) {
                System.out.println("Received: " + data);
            }

            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sslServerSocket.close();
    }
}