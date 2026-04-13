import java.io.*;
import java.net.*;

public class java_11129_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Waiting for client on port 6000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Read username and password from the client
            String username = dataInputStream.readUTF();
            String password = dataInputStream.readUTF();

            // Check if the username and password are valid
            if (isValid(username, password)) {
                System.out.println("Authenticated user: " + username);
                // If the username and password are valid, send a welcome message back to the client
                dataOutputStream.writeUTF("Welcome, " + username + "!");
            } else {
                System.out.println("Invalid username or password");
                // If the username or password is invalid, send an error message back to the client
                dataOutputStream.writeUTF("Invalid username or password");
           
            }

            dataOutputStream.close();
            socket.close();
        }
    }

    private static boolean isValid(String username, String password) {
        // Here you should use a real authentication system like SQL or a hash
        // For this example, we'll just check if the username and password are the same as the example
        return username.equals("admin") && password.equals("password");
    }

}