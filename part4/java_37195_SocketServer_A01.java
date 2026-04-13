import java.io.*;
import java.net.*;

public class java_37195_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        while (true) {
            Socket socket = server.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read request
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Process request
            String response;
            if (request.equals("Deny Access")) {
                response = "Access Denied";
            } else {
                response = "Access Granted";
            }

            // Send response
            out.writeUTF(response);
            out.flush();
        }
    }
}