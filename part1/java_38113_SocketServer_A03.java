import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_38113_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;

        try {
            // Creating SSL Server Socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            socket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, null, true);

            // SSL Server Socket Connection
            SSLSocket clientSocket = (SSLSocket) sslSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Send Certificate to the client
            out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
            out.flush();

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            // Close Socket Connection
            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) socket.close();
            if (sslSocket != null) sslSocket.close();
        }
    }
}