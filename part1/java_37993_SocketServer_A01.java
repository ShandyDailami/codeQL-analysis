import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_37993_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(12345);
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

        out.println("Hello, client!");

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
        }

        sslServerSocket.close();
    }
}