import java.io.*;
import java.net.*;

public class java_42107_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String clientMessage;
        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Received: " + clientMessage);

            // Simulate a security breach
            if (clientMessage.toLowerCase().contains("password")) {
                out.println("Access denied");
            } else {
                out.println("Access granted");
            }
        }

        socket.close();
        server.close();
    }
}