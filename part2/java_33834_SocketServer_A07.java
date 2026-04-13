import java.io.*;
import java.net.*;

public class java_33834_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket client = server.accept();
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Client says: " + request);

            // Checking if the request is authenticated
            if (isAuthenticated(request)) {
                dos.writeUTF("Successfully authenticated");
            } else {
                dos.writeUTF("Failed to authenticate");
            }

            client.close();
        }
    }

    // Simplified authentication check
    private static boolean isAuthenticated(String request) {
        // This is a simple check that assumes every request is authenticated if it starts with "auth"
        return request.startsWith("auth");
    }
}