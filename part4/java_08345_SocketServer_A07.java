import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08345_SocketServer_A07 {

    private static final String SERVER_MESSAGE = "Welcome to the server!";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // Assign a port number
            System.out.println("Server started. Listening on port: " + serverSocket.getLocalPort());
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected.");

                // Perform authentication here
                authenticateUser(socket);

                // Send a welcome message to the client
                sendWelcomeMessage(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void authenticateUser(Socket socket) {
        // Simulate authentication by checking if a user is authenticated
        // Replace this with actual authentication logic
        boolean isAuthenticated = true;
        if (!isAuthenticated) {
            closeSocket(socket);
            System.out.println("Authentication failed. Closing connection.");
            return;
        }
        System.out.println("Authentication successful.");
    }

    private static void sendWelcomeMessage(Socket socket) {
        try {
            socket.getOutputStream().write(SERVER_MESSAGE.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeSocket(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}