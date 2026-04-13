import java.io.*;
import java.net.*;

public class java_09152_SocketServer_A07 {
    private static final int port = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port: " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create stream for reading and writing
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read the username and password from the client
            String username = input.readUTF();
            String password = input.readUTF();

            // Here is the security-sensitive operation related to A07_AuthFailure
            // For simplicity, let's say the password is simply a reverse of the username
            String reversedPassword = new StringBuilder(password).reverse().toString();

            // Send the reversed password back to the client
            output.writeUTF(reversedPassword);
            output.flush();
       
            // Close the streams and the socket
            input.close();
            output.close();
            socket.close();
        }
    }
}