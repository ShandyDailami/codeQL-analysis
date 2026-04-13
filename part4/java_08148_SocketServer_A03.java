import java.io.DataOutputStream;
import java.io.IOException;
import java.net.SSLServerSocket;
import java.net.SSLSocket;
import java.net.Socket;

public class java_08148_SocketServer_A03 {
    private static final String SERVER_KEYSTORE = "server.jks";
    private static final String SERVER_TRUSTSTORE = "server.jks";
    private static final String SERVER_TRUSTSTORE_PASSWORD = "password";
    private static final String CLIENT_KEYSTORE = "client.jks";
    private static final String CLIENT_KEYPASSWORD = "password";

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080, null, null);
            serverSocket.setNeedClientAuth(true);

            socket = (SSLSocket) serverSocket.accept();
            socket.startHandshake();

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello from server!");
            out.flush();

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}