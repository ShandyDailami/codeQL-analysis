import java.net.*;
import java.io.*;
import javax.net.ssl.*;

public class java_36942_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        SSLServerSocket sslServer = null;
        try {
            // Create a SSLServerSocket
            server = new ServerSocket();
            server.setReuseAddress(true);
            server.bind(server);

            sslServer = (SSLServerSocket) server.accept();

            SSLSocket sslSock = (SSLSocket) sslServer.accept();

            // Setup input and output streams
            InputStream is = sslSock.getInputStream();
            OutputStream os = sslSock.getOutputStream();

            // Write a response
            os.write("Hello Client, You are connected to the server!\r\n".getBytes());
            os.flush();

            // Read from the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String line = in.readLine();
            while (line != null) {
                System.out.println("Received: " + line);
                line = in.readLine();
            }
            sslSock.close();
            sslServer.close();
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}