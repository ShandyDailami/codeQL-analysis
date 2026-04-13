import java.io.*;
import java.net.*;
import java.util.*;

public class java_39706_SocketServer_A07 {
    private static final String PASSWORD = "secure"; // hardcoded password for simplicity
    private static final String AUTHENTICATED_USER = "Authenticated User: ";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is listening at port: 6000");

        while (true) {
            System.out.println("Waiting for a client...");
            Socket socket = server.accept();
            System.out.println("Client has connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            String password = in.readUTF();
            if (password.equals(PASSWORD)) {
                out.writeUTF(AUTHENTICATED_USER + socket.getRemoteSocketAddress().toString());
            } else {
                out.writeUTF("Access Denied");
            }

            socket.close();
        }
    }
}