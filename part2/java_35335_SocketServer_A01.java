import java.io.*;
import java.net.*;

public class java_35335_SocketServer_A01 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for a client ...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            if ("exit".equals(message)) {
                break;
            }

            if (message.equals(USERNAME + ":" + PASSWORD)) {
                out.println("Welcome, authenticated user!");
            } else {
                out.println("Invalid username or password");
           
            }
            out.flush();
        }
        socket.close();
        server.close();
    }
}