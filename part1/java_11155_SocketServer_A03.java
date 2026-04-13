import java.io.*;
import java.net.*;

public class java_11155_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // default port
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept(); // waiting for client to connect
            System.out.println("Client connected");

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read username from client
            String username = in.readUTF();

            // check if the username is valid
            if (isValidUsername(username)) {
                // send welcome message to client
                out.writeUTF("Welcome, " + username);
            } else {
                out.writeUTF("Invalid username. Please enter a valid username.");
            }

            // close streams
            out.close();
            in.close();
            socket.close();
        }
    }

    private static boolean isValidUsername(String username) {
        // here you can add your own validation logic, for example:
        return username != null && !username.isEmpty();
    }

}