import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_00432_SocketServer_A07 {
    private final static SecureRandom sr = new SecureRandom();
    private final static String[] USERS = {"user1", "user2", "user3"};
    private final static String[] PASSWORDS = {"password1", "password2", "password3"};

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080);
        serverSocket.setReuseAddress(true);

        while (true) {
            SSLServerSocket sockets = (SSLServerSocket) serverSocket.accept();
            Socket clientSocket = sockets.accept();

            InetAddress clientAddress = clientSocket.getInetAddress();
            System.out.println("Accepted connection from: " + clientAddress);

            SSLSocket sslSocket = (SSLSocket) sockets.accept();
            String user = sslSocket.getRemoteSocket().getInetAddress().toString();
            String password = sr.nextInt() + ""; // Assuming we are using an authentication mechanism that generates a secure random password

            System.out.println("Authentication from: " + user + " Password: " + password);

            if (!authenticate(user, password)) {
                System.out.println("Authentication failed!");
                sslSocket.close();
                clientSocket.close();
            } else {
                System.out.println("Authentication successful!");
                // Handle the client
            }
        }
    }

    private static boolean authenticate(String user, String password) {
        for (String u : USERS) {
            if (u.equals(user)) {
                for (String p : PASSWORDS) {
                    if (p.equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}