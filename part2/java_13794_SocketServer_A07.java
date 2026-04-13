import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_13794_SocketServer_A07 {

    private static SecretKey secretKey = new SecretKeySpec("key".getBytes(), "AES");

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientRequest = in.readUTF();

            // Perform authentication here, this is a simplistic example
            if (authenticate(clientRequest)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
            }

            socket.close();
        }
    }

    private static boolean authenticate(String request) {
        // Implement your own authentication logic here. This is just a placeholder.
        // This method just checks if the request is "A07_AuthFailure".
        return request.equals("A07_AuthFailure");
    }
}