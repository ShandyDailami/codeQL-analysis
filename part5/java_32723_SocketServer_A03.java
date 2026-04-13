import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.*;

public class java_32723_SocketServer_A03 {

    private static SSLServerSocket serverSocket;
    private static SSLSocket socket;
    private static BufferedReader in = null;
    private static PrintWriter out = null;

    public static void main(String[] args) {

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8888, null, null, null, false);
            serverSocket.setNeedClientAuth(true);
            socket = (SSLSocket) serverSocket.accept();
            socket.startHandshake();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Client connected");

            String clientInput;

            while ((clientInput = in.readLine()) != null) {
                System.out.println("Received: " + clientInput);
                out.println("Hello, Client, Message received");
            }

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}