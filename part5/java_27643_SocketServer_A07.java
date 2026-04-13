import java.net.*;
import java.io.*;
import java.util.*;

public class java_27643_SocketServer_A07 {
    private static final String AUTH_USERNAME = "admin";
    private static final String AUTH_PASSWORD = "password";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
            System.out.println("Server is listening on port 6666");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientRequest = dataInputStream.readUTF();
                System.out.println("Received: " + clientRequest);

                String response = authenticateClient(clientRequest);
                dataOutputStream.writeUTF(response);
                dataOutputStream.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String authenticateClient(String clientRequest) {
        String[] parts = clientRequest.split(" ");

        if (parts.length != 2) {
            return "FAIL";
        }

        String username = parts[0];
        String password = parts[1];

        if (!username.equals(AUTH_USERNAME) || !password.equals(AUTH_PASSWORD)) {
            return "FAIL";
        }

        return "OK";
    }
}