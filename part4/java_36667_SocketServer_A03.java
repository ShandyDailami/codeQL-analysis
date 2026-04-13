import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36667_SocketServer_A03 {
    private static SSLServerSocket serverSocket;
    private static Socket clientSocket;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuthentication(true);
            clientSocket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) clientSocket.getTransportSocket();
            sslSocket.setNeedClientAuth(true);

            in = new DataInputStream(sslSocket.getInputStream());
            out = new DataOutputStream(sslSocket.getOutputStream());

            System.out.println("Client Connected: " + clientSocket.getRemoteSocketAddress());
            String clientInput;

            while ((clientInput = in.readUTF()) != null) {
                System.out.println("Received: " + clientInput);
                out.writeUTF("Server says: " + clientInput);
                out.flush();
            }

            sslSocket.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}