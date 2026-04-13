import java.io.*;
import java.net.*;

public class java_09402_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 6000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read the username from the client
                String username = in.readUTF();
                System.out.println("Username received: " + username);

                // Check if the received username is valid
                if(isValidUsername(username)) {
                    out.writeUTF("Authentication successful");
                    out.flush();
                } else {
                    out.writeUTF("Authentication failed");
                    out.flush();
               
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidUsername(String username) {
        // Simple validation: check if the username is not null and not empty
        return username != null && !username.isEmpty();
    }
}