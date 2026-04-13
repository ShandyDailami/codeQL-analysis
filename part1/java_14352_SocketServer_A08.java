import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14352_SocketServer_A08 {
    private static final int port = 9876;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here, we only check if the socket is authenticated
                // This is a very simplistic example and in a real application,
                // you would need to use a more secure method to authenticate the client.
                if (socket.getAuthentication().isAuthenticated()) {
                    System.out.println("Client is authenticated");
                } else {
                    System.out.println("Client is not authenticated");
                }

                // Close the socket and go to the next iteration of the loop
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}