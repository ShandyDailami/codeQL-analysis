import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_33990_SocketServer_A07 {
    private static final String PASSWORD = "securepassword";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.accept();

        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

        String clientMessage;
        while ((clientMessage = in.readLine()) != null) {
            if ("QUIT".equals(clientMessage)) {
                out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                sslSocket.close();
                serverSocket.close();
                System.out.println("Connection closed by client");
                break;
            } else {
                out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                out.writeBytes(clientMessage + "\r\n");
            }
        }

        sslServerSocket.close();
        serverSocket.close();
    }
}