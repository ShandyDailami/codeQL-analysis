import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_27872_SocketServer_A07 {
    private final int port;

    public java_27872_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                SSLSocket clientSocket = sslServerSocket.accept();
                System.out.println("Client connected!");

                // Perform necessary security sensitive operations
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);
                    // Perform some operation here
                    // e.g., send response
                    out.writeBytes("Server: Handling request: " + request + "\n");
                    out.flush();
                }

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(8080);
        server.start();
    }
}