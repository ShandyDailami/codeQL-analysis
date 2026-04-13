import java.io.*;
import java.net.*;

public class java_02948_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            if ("A08_IntegrityFailure".equals(request)) {
                out.writeUTF("Security Violation Detected");
            } else {
                out.writeUTF("Request not recognized");
            }

            out.close();
            socket.close();
        }
    }
}