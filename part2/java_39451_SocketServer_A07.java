import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39451_SocketServer_A07 {

    private static final String AUTHENTICATED_USER = "Authenticated User";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Authenticate the client
            String clientName = socket.getInetAddress().toString();
            if (!authenticate(clientName)) {
                System.out.println("Authentication failed for " + clientName);
                socket.close();
                continue;
            }

            // Handle the client
            handleClient(socket);
       
            socket.close();
        }
    }

    private static boolean authenticate(String clientName) {
        // In this method, we're simulating authentication with a fixed password.
        // In a real-world scenario, you would want to use a more sophisticated
        // method of authentication, possibly involving SSL/TLS for secure communication.
        return clientName.equals(AUTHENTICATED_USER) && clientName.equals(PASSWORD);
    }

    private static void handleClient(Socket socket) throws IOException {
        // This method is left blank because it is assumed that the client will
        // send data to the server and the server will send data back to the client.
        // In a real-world scenario, the client would send a command and the server
        // would respond accordingly.
    }
}