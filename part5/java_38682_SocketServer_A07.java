import java.io.*;
import java.net.*;

public class java_38682_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for a client...");

        Socket socket = server.accept();
        System.out.println("Client accepted!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // read username and password
        String client_username = in.readUTF();
        String client_password = in.readUTF();

        // hardcoded for simplicity, in real applications should use secure way of handling
        String correct_username = "admin";
        String correct_password = "password";

        if (client_username.equals(correct_username) && client_password.equals(correct_password)) {
            out.writeUTF("Welcome!");
        } else {
            out.writeUTF("Authentication failed!");
       
        }

        socket.close();
    }
}