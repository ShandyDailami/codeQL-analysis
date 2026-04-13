import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23105_SocketServer_A07 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // read username and password from client
                String clientUsername = socket.getInputStream().readUTF();
                String clientPassword = socket.getInputStream().readUTF();

                // check if username and password match
                if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                    // write success response to client
                    socket.getOutputStream().writeUTF("Success");
                    socket.getOutputStream().flush();
                } else {
                    // write failure response to client
                    socket.getOutputStream().writeUTF("Failure");
                    socket.getOutputStream().flush();
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}