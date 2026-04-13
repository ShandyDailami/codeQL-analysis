import java.io.*;
import java.net.*;

public class java_36731_SocketServer_A07 {

    private static final int port = 6666;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
       
        }
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive the username from the client
                String username = in.readUTF();
                System.out.println("Username is " + username);

                // Send a welcome message to the client
                out.writeUTF("Welcome, " + username);
                out.flush();

                // Receive the password from the client
                String password = in.readUTF();
                System.out.println("Password is " + password);

                // Check if the password is correct
                if (password.equals("secret")) {
                    System.out.println("Authentication successful!");
                    out.writeUTF("Success");
                } else {
                    System.out.println("Authentication failed!");
                    out.writeUTF("Failed");
                }

                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}