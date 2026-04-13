import java.io.*;
import java.net.*;

public class java_29533_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Authentication
            if (authenticate(dataInputStream)) {
                dataOutputStream.writeUTF("Authentication successful");
            } else {
                dataOutputStream.writeUTF("Authentication failed");
           
                // Close the connection if authentication fails
                socket.close();
            }
        }
    }

    private static boolean authenticate(DataInputStream dataInputStream) throws IOException {
        // Reading user credentials from the input stream
        String username = dataInputStream.readUTF();
        String password = dataInputStream.readUTF();

        // Authentication code here...
        // For simplicity, let's assume the username and password are correct
        return username.equals("admin") && password.equals("password");
    }
}