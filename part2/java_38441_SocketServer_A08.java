import java.io.*;
import java.net.*;

public class java_38441_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for client connection...");

        Socket client = server.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        String request = in.readUTF();
        System.out.println("Received: " + request);

        // Security-sensitive operation related to integrity failure
        if (!isValidRequest(request)) {
            out.writeUTF("Invalid request!");
            out.flush();
            return;
        }

        out.writeUTF("Success!");
        out.flush();

        client.close();
    }

    private static boolean isValidRequest(String request) {
        // Implement security-sensitive operations related to integrity failure here
        // This is a placeholder for your code
        return request.equals("ExpectedRequest");
    }
}