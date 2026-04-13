import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_35390_SocketServer_A07 {

    private Map<String, String> users = new HashMap<>();

    public java_35390_SocketServer_A07() {
        users.put("admin", "password");
    }

    public static void main(String[] args) {
        new SecureSocketServer().run();
    }

    public void run() {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080)) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);

            System.out.println("Client is authenticating...");

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            // Read the username and password from the client
            byte[] bytes = new byte[1024];
            int length = inputStream.read(bytes);
            String user = new String(bytes, 0, length);
            String password = readPassword(inputStream);

            // Authenticate the user
            if ("admin".equals(user) && "password".equals(password)) {
                System.out.println("User is authenticated successfully");
                outputStream.write("Authentication successful".getBytes());
            } else {
                System.out.println("User is not authenticated");
                outputStream.write("Authentication failed".getBytes());
            }

            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readPassword(InputStream inputStream) {
        byte[] bytes = new byte[1024];
        int length;
        StringBuilder sb = new StringBuilder();

        try {
            while ((length = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}