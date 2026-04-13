import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36395_SocketServer_A08 {
    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;
        BufferedReader reader = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Connection from " + clientSocket.getRemoteSocketAddress());

                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                }

                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                writer.println("Hello, Client, Thanks for connecting!");
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}