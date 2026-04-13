import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_08850_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 8080;
        String protocol = "TLSv1.2";

        System.out.println("Starting SSL Server on port: " + port + " using protocol: " + protocol);

        try (SSLServerSocket serverSocket = (SSLServerSocket) (protocol.equals("TLSv1.2") ? new SSLServerSocket(port) : new ServerSocket(port))) {

            SSLSocket socket = (SSLSocket) serverSocket.accept();
            socket.setEnabledCipherSuites(new String[]{"TLSv1.2"});
            socket.setEnabledKeyAndCertificateAliases(true);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            // Here is where you would perform operations that require secure communication.
            // For example, reading from the socket or writing to the socket.

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}