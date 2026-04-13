import java.io.*;
import java.net.*;
import java.util.*;

public class java_40457_SocketServer_A07 {
    private static final String AUTH_FAILURE = "A07_AuthFailure";

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // create server socket
            server = new ServerSocket(12345);

            System.out.println("Waiting for client...");

            // accept client
            socket = server.accept();
            System.out.println("Client connected");

            // create input stream from client socket
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String clientMessage = in.readUTF();

            // process client message (e.g., authenticate user)
            // for simplicity, we'll just check if the message contains the auth failure code
            if (clientMessage.contains(AUTH_FAILURE)) {
                System.out.println("Authentication failed. Closing connection...");
                socket.close();
            } else {
                System.out.println("Authentication successful. Sending response...");
                // send response to client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Authentication successful!");
            }

            // close resources
            in.close();
            out.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}