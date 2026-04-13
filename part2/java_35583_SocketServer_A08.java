import java.io.*;
import java.net.*;
import java.util.Scanner;

public class java_35583_SocketServer_A08 {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String password = "password";
        String clientMessage;

        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Received: " + clientMessage);
            if (clientMessage.equals(password)) {
                System.out.println("Authenticated successfully");
                out.println("Authentication successful");
            } else {
                System.out.println("Authentication failed");
                out.println("Authentication failed");
            }
            out.flush();
        }

        socket.close();
        server.close();
    }
}