import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class java_38052_SocketServer_A07 {

    private static final String IP_ADDRESS = "127.0.0.1";
    private static final int PORT = 4445;
    private static final String PASSWORD = "password";

    private Map<String, String> users = new HashMap<>();

    public java_38052_SocketServer_A07() {
        users.put("user", PASSWORD);
    }

    public void start() {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT, 100, InetAddress.getByName(IP_ADDRESS));

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Client connected");

                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();

                handleRequest(inputStream, outputStream);
                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleRequest(InputStream inputStream, OutputStream outputStream) {
        // Read password from input stream
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String password = new String(buffer);

        // Check password
        if (users.get(password).equals(PASSWORD)) {
            outputStream.write("OK\n".getBytes());
            outputStream.flush();
        } else {
            outputStream.write("FAIL\n".getBytes());
            outputStream.flush();
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer().start();
    }
}