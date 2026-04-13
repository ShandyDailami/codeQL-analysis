import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_28744_SocketServer_A01 {
    private static SSLServerSocket serverSocket;
    private static Socket clientSocket;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
                sslSocket.startHandshake();

                // Check if client is authenticated
                if (sslSocket.getSession().equals(SSLSession.getDefaultSession())) {
                    System.out.println("Client is authenticated!");
                    // Start input and output streams
                    DataInputStream dis = new DataInputStream(sslSocket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(sslSocket.getOutputStream());

                    // Write to the client
                    dos.writeUTF("Hello client!");
                    dos.flush();

                    // Read from the client
                    String message = dis.readUTF();
                    System.out.println("Message from client: " + message);

                    // Close the connections
                    dis.close();
                    dos.close();
                    clientSocket.close();
                } else {
                    System.out.println("Client is not authenticated!");
                    // Close the connections
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}