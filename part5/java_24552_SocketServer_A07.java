import java.io.*;
import java.net.*;

public class java_24552_SocketServer_A07 {
    private static final String PASSWORD = "secure";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        while (true) {
            Socket socket = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String clientMessage = reader.readLine();
            if (clientMessage.equals(PASSWORD)) {
                writer.writeBytes("auth successful\n");
            } else {
                writer.writeBytes("auth failure\n");
           
            }
            socket.close();
        }
    }
}