import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_29132_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 8080;

        // Use SSL to secure the connection
        boolean useSSL = true;
        if (useSSL) {
            try {
                SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(port);
                System.out.println("Server listening on port " + port + "...");

                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Perform basic authentication
                String clientCert = socket.getRequestedSessionParameters().get(SSLSocket.REQUESTED_SESSION_PARAMETERS);
                // For simplicity, we'll assume a valid client certificate
                // In a real-world scenario, you'd want to check the certificate against a trusted list
                if (clientCert == null) {
                    System.out.println("Client certificate not provided or invalid!");
                    serverSocket.close();
                    return;
                }

                // Continue with the rest of the code...

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("Server listening on port " + port + "...");

                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Perform basic authentication
                String clientIP = socket.getInetAddress().getHostAddress();
                // Again, for simplicity, we'll assume a valid client IP
                // In a real-world scenario, you'd want to check against a trusted list
                if ("127.0.0.1".equals(clientIP)) {
                    System.out.println("Client IP not provided or invalid!");
                    serverSocket.close();
                    return;
                }

                // Continue with the rest of the code...

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}