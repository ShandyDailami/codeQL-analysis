import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_39630_SocketServer_A07 {
    private static final String CLIENT_IDENTIFIER = "Client_Identifier";
    private static final String SERVER_KEYSTORE = "server.jks";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String CLIENT_KEYSTORE = "client.jks";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final int PORT = 443;
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT, null, InetAddress.getByName("localhost"));
        serverSocket.setNeedClientAuth(true);
        SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.accept();
        sslServerSocket.setNeedClientAuth(true);

        SSLSocket socket = (SSLSocket) sslServerSocket.accept();
        socket.setNeedClientAuth(true);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        // Send client identifier for authentication
        writer.println(CLIENT_IDENTIFIER);
        writer.flush();

        // Wait for authentication from client
        String auth = reader.readLine();
        if (!auth.equals(CLIENT_IDENTIFIER)) {
            System.out.println("Authentication failed");
            return;
        }

        // Start receiving data
        while (true) {
            String data = reader.readLine();
            if (data == null) {
                break;
            }
            System.out.println("Received: " + data);
        }
    }
}