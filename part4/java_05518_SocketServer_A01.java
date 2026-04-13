import java.io.*;
import java.net.*;

public class java_05518_SocketServer_A01 {

    private static int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String request = input.readUTF();
            System.out.println("Received request: " + request);

            // Here, we can implement the security sensitive operation
            // For example, we can add a simple check to ensure the request contains a username and password
            // If the request does not contain these, we can deny access
            if (!request.contains("username") || !request.contains("password")) {
                output.writeUTF("Access Denied");
            } else {
                output.writeUTF("Access Granted");
           
            }

            output.close();
            socket.close();
        }
    }
}