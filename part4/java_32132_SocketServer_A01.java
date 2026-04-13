import java.io.*;
import java.net.*;

public class java_32132_SocketServer_A01 {
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // read username from client
                String clientName = in.readLine();

                // check if password matches
                if (clientName.equals(PASSWORD)) {
                    System.out.println("Access granted to " + clientName);
                    out.writeBytes("Access granted\n");
                } else {
                    System.out.println("Access denied for " + clientName);
                    out.writeBytes("Access denied\n");
                    socket.close();
                    continue;
                }

                // read and send back message from client
                String message = in.readLine();
                System.out.println("Received message from client: " + message);
                out.writeBytes("Message sent back: " + message + "\n");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}