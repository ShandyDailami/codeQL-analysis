import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00208_SocketServer_A07 {

    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected at: " + socket.getRemoteSocketAddress());

                // Here you can add your AuthFailure logic
                // For the sake of simplicity, we'll just validate if the socket is valid
                if (validateSocket(socket)) {
                    System.out.println("Client authenticated successfully!");
                } else {
                    System.out.println("Authentication failed, client disconnected!");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean validateSocket(Socket socket) {
        // Implement your own auth logic here
        // For the sake of simplicity, we'll just check if the socket is not null
        return socket != null;
    }
}