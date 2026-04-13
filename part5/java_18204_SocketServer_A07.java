import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18204_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started!");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            String clientMessage = socket.getInputStream().readUTF();
            System.out.println("Received: " + clientMessage);

            if (authenticateClient(socket)) {
                System.out.println("Client authenticated!");
                socket.getOutputStream().writeUTF("Success!");
            } else {
                System.out.println("Authentication failed!");
                socket.getOutputStream().writeUTF("Failed!");
            }

            socket.close();
        }
    }

    private static boolean authenticateClient(Socket socket) {
        String username = socket.getInputStream().readUTF();
        String password = socket.getInputStream().readUTF();

        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}