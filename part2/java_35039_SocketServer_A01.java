import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_35039_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        SSLServer(9999);
    }

    public static void SSLServer(int port) throws Exception {
        ServerSocket sockets = new ServerSocket(port);
        SSLServerSocket sslSockets = (SSLServerSocket) sockets.acceptSSL();

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSockets.getInputStream()));
        DataOutputStream out = new DataOutputStream(sslSockets.getOutputStream());

        // Read request
        String request = in.readLine();
        System.out.println("Received: " + request);

        // Send response
        out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
        out.flush();

        sslSockets.close();
        sockets.close();
    }
}