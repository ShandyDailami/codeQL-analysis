import java.io.*;
import java.net.*;
import java.util.*;

public class java_07795_SocketServer_A07 {
    private static final String AUTH_FAILURE_ERROR = "A07_AuthFailure";
    private static final String SERVER_MESSAGE = "Hello from Secure Socket Server!";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);

        while (true) {
            Socket socket = server.accept();
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            String clientMessage = in.readUTF();
            if (clientMessage.equals(AUTH_FAILURE_ERROR)) {
                out.writeUTF(AUTH_FAILURE_ERROR);
                out.close();
                socket.close();
                continue;
            }

            out.writeUTF(SERVER_MESSAGE);
            out.close();
            socket.close();
        }
    }
}