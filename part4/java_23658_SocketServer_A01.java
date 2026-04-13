import java.io.*;
import java.net.*;

public class java_23658_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client connection...");
        Socket socket = server.accept();
        System.out.println("Client connected!");

        // InputStreamReader for reading the data, and OutputStreamWriter for writing the data
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String clientMessage;
        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Received: " + clientMessage);

            // Here you could add some security-sensitive operations
            // For example, checking if the client is authorized to perform certain actions
            if (clientMessage.equals("authorized_user")) {
                out.println("Access granted, you can send/receive messages now");
            } else {
                out.println("Access denied, please re-authenticate");
            }
        }

        socket.close();
        server.close();
    }
}