import java.io.*;
import java.net.*;

public class java_09547_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client has connected!");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // read the username from the client
                String username = in.readUTF();
                System.out.println("Received username: " + username);

                // send a welcome message back to the client
                String response = "Welcome " + username + "!\n";
                out.writeUTF(response);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}