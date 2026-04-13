import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_31956_SocketServer_A08 {

    private static final String SSL_PORT = "4444";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
            serverSocket.setNeedClientAuthentication(true);

            System.out.println("Server is listening on port " + SSL_PORT);
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted client connection from " + clientSocket.getRemoteSocketAddress());

                // Create new thread for each client
                Thread thread = new Thread(new SocketHandler(clientSocket));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private final Socket socket;

    public java_31956_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Request client certificate
            out.writeBytes("GET /index.html HTTP/1.1\r\nHost: localhost:8080\r\nAccept: */*\r\n\r\n");
            out.flush();

            // Read response from client
            String response = in.readLine();
            System.out.println("Server response: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}