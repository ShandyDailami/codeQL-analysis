import java.io.*;
import java.net.*;

public class java_22434_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Here we are assuming that the client's IP address is the only one involved.
            InetAddress clientAddr = socket.getInetAddress();
            System.out.println("Client IP: " + clientAddr.getHostAddress());

            // Checking if the client IP is allowed. Here, we only allow connections from a specific IP.
            if (!clientAddr.getHostAddress().equals("127.0.0.1")) {
                System.out.println("Access Denied");
                socket.close();
                continue;
            }

            // If the client IP is allowed, proceed with communication.
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.writeBytes("Message received\n");
            }

            socket.close();
        }
    }
}