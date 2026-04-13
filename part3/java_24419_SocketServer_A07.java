import java.io.*;
import java.net.*;
import java.util.*;

public class java_24419_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMsg = in.readUTF();
            String serverMsg;

            StringTokenizer st = new StringTokenizer(clientMsg);
            String clientUser = st.nextToken();
            String clientPass = st.nextToken();

            if (clientUser.equals(USERNAME) && clientPass.equals(PASSWORD)) {
                serverMsg = "Authentication successful. Message from client: " + clientMsg;
                out.writeUTF(serverMsg);
            } else {
                serverMsg = "Authentication failed.";
                out.writeUTF(serverMsg);
            }

            out.flush();
            socket.close();
        }
    }
}