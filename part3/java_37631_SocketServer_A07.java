import java.io.*;
import java.net.*;
import java.util.*;

public class java_37631_SocketServer_A07 {

    private static final String AUTH_MESSAGE = "A07_AuthFailure";
    private static final int PORT = 4445;
    private static Set<Socket> authorizedSockets = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String clientMessage = reader.readLine();
            System.out.println("Received: " + clientMessage);

            if (authenticateClient(socket)) {
                writer.writeBytes("Authentication successful\n");
            } else {
                writer.writeBytes("Authentication failed\n");
                socket.close();
                continue;
            }

            writer.writeBytes("Message received\n");
            socket.close();
        }
    }

    private static boolean authenticateClient(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

        writer.writeBytes("Enter password: ");
        writer.flush();

        String password = reader.readLine();
        System.out.println("Entered password: " + password);

        if (password.equals(AUTH_MESSAGE)) {
            authorizedSockets.add(socket);
            return true;
        }

        return false;
    }
}