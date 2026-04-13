import java.io.*;
import java.net.*;

public class java_14538_SocketServer_A07 {
    private static final String AUTH_SUCCESS = "Authentication successful";
    private static final String AUTH_FAILURE = "Authentication failed";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for client...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // Read the username and password from the client
                String username = dataInputStream.readUTF();
                String password = dataInputStream.readUTF();

                // Authenticate the user (This is a placeholder, replace with actual authentication logic)
                boolean isAuthenticated = authenticate(username, password);

                // Send the authentication result to the client
                if (isAuthenticated) {
                    dataOutputStream.writeUTF(AUTH_SUCCESS);
                } else {
                    dataOutputStream.writeUTF(AUTH_FAILURE);
                }

                dataOutputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String username, String password) {
        // This is a placeholder, replace with actual authentication logic
        return username.equals("admin") && password.equals("password");
    }
}