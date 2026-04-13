import java.io.*;
import java.net.*;
import java.util.*;

public class java_23741_SocketServer_A07 {

    private static final String USER = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started!");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read username and password from client
            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            // check if username and password match
            if (clientUsername.equals(USER) && clientPassword.equals(PASSWORD)) {
                System.out.println("Authentication successful!");
                out.writeUTF("Authentication successful");
            } else {
                System.out.println("Authentication failed!");
                out.writeUTF("Authentication failed");
           
            }
            // close the streams and socket
            out.close();
            in.close();
            socket.close();
        }
    }
}