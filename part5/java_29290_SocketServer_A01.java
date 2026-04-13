import java.net.*;
import java.io.*;
import java.security.*;

public class java_29290_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Get the security manager
            SecurityManager sm = System.getSecurityManager();

            // Set up the connection to be secure
            if (sm != null) {
                sm.checkUserAccess(clientSocket.getInetAddress().getHostAddress());
            }

            // Create input and output streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Send a greeting to the client
            out.writeUTF("Hello client, you are now connected to secure server!");
        }
    }
}