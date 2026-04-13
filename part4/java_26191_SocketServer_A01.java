import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_26191_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(10000);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) clientSocket.getUnderlyingSocket();

                System.out.println("Client connected");
                OutputStream outToClient = sslSocket.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToClient);
                out.writeUTF("Connection successful");
                out.close();
                sslSocket.close();
                clientSocket.close();
            }
        } catch (SSLException e) {
            e.printStackTrace();
        }
    }
}