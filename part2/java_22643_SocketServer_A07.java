import java.io.*;
import java.net.*;
import java.util.*;

public class java_22643_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "Authenticated user";
    private static final String FAILURE_REASON = "Auth failure";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client message: " + clientMessage);

            if (authenticateUser(clientMessage)) {
                dataOutputStream.writeUTF(AUTHENTICATED_USER);
                System.out.println("Authenticated, sending response.");
            } else {
                dataOutputStream.writeUTF(FAILURE_REASON);
                System.out.println("Failed to authenticate, sending response.");
            }

            dataOutputStream.close();
            socket.close();
        }
    }

    private static boolean authenticateUser(String clientMessage) {
        // We're using a fixed password for simplicity. In a real application,
        // you'd likely use a more sophisticated method of authentication.
        return clientMessage.equals(PASSWORD);
    }
}