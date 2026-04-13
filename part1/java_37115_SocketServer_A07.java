import java.io.*;
import java.net.*;
import java.util.*;

public class java_37115_SocketServer_A07 {
    private static final String AUTH_SUCCESS = "AuthSuccess";
    private static final String AUTH_FAILURE = "AuthFailure";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started!");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            if (clientMessage.equals("username") && clientMessage.equals("password")) {
                out.writeUTF(AUTH_SUCCESS);
            } else {
                out.writeUTF(AUTH_FAILURE);
            }

            clientSocket.close();
        }
    }
}