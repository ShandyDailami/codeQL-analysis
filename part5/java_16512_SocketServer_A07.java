import java.net.ServerSocket;
import java.net.Socket;

public class java_16512_SocketServer_A07 {
    private static final String AUTH_SUCCESS = "Auth successful";
    private static final String AUTH_FAILURE = "Auth failure";
    private static final String PASSWORD = "password"; // hardcoded for demonstration purposes

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // port number
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Perform authentication
                if (authenticate(socket)) {
                    System.out.println(AUTH_SUCCESS);
                } else {
                    System.out.println(AUTH_FAILURE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // Add your own authentication logic here. For simplicity, we'll just accept any username
        // and password. This is not secure for real-world applications.
        try {
            String clientMessage = new String(socket.getInputStream().readNBytes(1024), "UTF-8");
            String[] authInfo = clientMessage.split(":");
            String username = authInfo[0];
            String password = authInfo[1];

            return password.equals(PASSWORD) && username.equals("client");
        } catch (Exception e) {
            return false;
        }
    }
}