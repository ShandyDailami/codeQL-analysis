import java.io.*;
import java.net.*;

public class java_32802_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Perform security-sensitive operations here
            // For example, check the client's IP address
            InetAddress clientAddress = clientSocket.getInetAddress();
            if (!isSecureAddress(clientAddress)) {
                System.out.println("Client " + clientAddress + " is not secure, closing connection...");
                clientSocket.close();
            } else {
                // Process the request and send a response
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String request = in.readLine();
                System.out.println("Received request: " + request);

                // TODO: Secure response here (e.g., adding authentication and authorization)
                // For example, generate a secure response
                String response = "Hello, client, secure connection!";
                out.writeBytes(response + '\n');
                out.flush();
            }
        }
    }

    private static boolean isSecureAddress(InetAddress addr) {
        byte[] ipBytes = addr.getAddress();
        return ((ipBytes[0] & 0x02) == 0x01) && ((ipBytes[0] & 0x08) != 0x08); // 10.0.0.0/8
    }
}