import java.io.*;
import java.net.*;

public class java_33869_SocketServer_A01 {
    private static final int PORT = 6789;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            Socket client = server.accept();

            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            String clientMessage = input.readUTF();

            if (isSecure(clientMessage)) {
                String serverMessage = "Access granted!";
                output.writeUTF(serverMessage);
                output.flush();
            } else {
                String serverMessage = "Access denied!";
                output.writeUTF(serverMessage);
                output.flush();
           
                client.close();
            }

            server.close();
        }
    }

    private static boolean isSecure(String message) {
        // Implementation of security-sensitive operations here. 
        // This is a placeholder for the actual implementation.
        return true;
    }
}