import java.io.*;
import java.net.*;
import java.util.*;

public class java_01279_SocketServer_A07 {
    private static final String AUTHENTICATE = "AUTHENTICATE";
    private static final String SUCCESS = "SUCCESS";
    private static final String FAILURE = "FAILURE";
    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "testpassword";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            while (true) {
                Socket socket = server.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMsg = in.readUTF();
                System.out.println("Received: " + clientMsg);

                if (clientMsg.equals(AUTHENTICATE)) {
                    String receivedUser = in.readUTF();
                    String receivedPassword = in.readUTF();
                    if (receivedUser.equals(USERNAME) && receivedPassword.equals(PASSWORD)) {
                        out.writeUTF(SUCCESS);
                        out.flush();
                    } else {
                        out.writeUTF(FAILURE);
                        out.flush();
                    }
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}