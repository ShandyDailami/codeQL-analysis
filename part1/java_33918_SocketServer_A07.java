import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33918_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        while (true) {
            Socket socket = server.accept();
            String clientUsername = socket.getInputStream().readUTF();
            String clientPassword = socket.getInputStream().readUTF();

            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                System.out.println("Authentication successful!");
                socket.getOutputStream().writeUTF("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
                socket.getOutputStream().writeUTF("Authentication failed!");
           
            }
            socket.close();
        }
    }
}