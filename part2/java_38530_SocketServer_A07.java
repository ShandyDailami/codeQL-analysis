import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_38530_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        int port = 5000; // default port
        String protocol = "TCP"; // default protocol

        if (protocol.equals("SSL")) {
            SSLServerSocket sslsock = (SSLServerSocket) new SSLServerSocket(port);
            Socket sock = sslsock.accept();
            handleClient(sock);
        } else if (protocol.equals("TCP")) {
            ServerSocket socket = new ServerSocket(port);
            while (true) {
                Socket client = socket.accept();
                handleClient(client);
            }
        } else {
            System.out.println("Invalid protocol. Please use either 'TCP' or 'SSL'.");
        }
    }

    private static void handleClient(Socket client) throws IOException {
        System.out.println("Connection established from " + client.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        // read username and password from client
        String username = in.readUTF();
        String password = in.readUTF();

        // authenticate client
        if (authenticate(username, password)) {
            out.writeUTF("Authentication successful");
        } else {
            out.writeUTF("Authentication failed");
            return;
        }

        // close connection
        out.writeUTF("Connection closed");
        client.close();
    }

    private static boolean authenticate(String username, String password) {
        // replace this with actual authentication code
        // for simplicity, we're checking if the username and password are valid
        return username.equals("admin") && password.equals("password");
    }
}