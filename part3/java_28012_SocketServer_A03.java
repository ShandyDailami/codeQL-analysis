import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_28012_SocketServer_A03 {
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();

        // create SSLServerSocket with specified port and SSLSocketFactory
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
        serverSocket.setNeedClientAuth(true);

        // accept a connection
        SSLSocket client = (SSLSocket) serverSocket.accept();
        client.startHandshake();

        // verify if client is authenticated
        if(client.getSession() != null){
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hello Client, You are authenticated");
        }else{
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Error: Client is not authenticated");
        }

        // close the connection
        client.close();
    }
}