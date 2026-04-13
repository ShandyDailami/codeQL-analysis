import java.io.*;
import java.net.*;

public class java_13446_SocketServer_A07 {
    private static final String SERVER_SOCKET = "My Server";
    private static final int PORT = 4446;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
                DataInputStream inFromClient = new DataInputStream(socket.getInputStream());

                String userInput = inFromClient.readUTF();
                System.out.println("Received: " + userInput);

                if (validateUser(userInput)) {
                    outToClient.writeUTF("Authentication successful");
                } else {
                    outToClient.writeUTF("Authentication failed");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean validateUser(String userInput) {
        // Here you should add your own authentication logic
        // This is a simple example where we accept all users
        return userInput.equals("username") && userInput.equals("password");
    }
}