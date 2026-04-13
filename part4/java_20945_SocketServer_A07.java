import java.io.*;
import java.net.*;

public class java_20945_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Security sensitive operation related to A07_AuthFailure
                // Implementing client side SSL/TLS for authentication
                SSLServerSocket sslServerSocket = (SSLServerSocket) socket.getShared().getWrappedSocket();
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

                // Write a response
                out.writeBytes("Hello, Client!\r\n");
                out.flush();

                // Close the socket
                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}