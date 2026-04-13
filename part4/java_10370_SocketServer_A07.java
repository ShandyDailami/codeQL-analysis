import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10370_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // Listening port
            System.out.println("Server is listening on port 1234...");

            while (true) {
                Socket socket = serverSocket.accept(); // Accepting a new connection
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Handle the connection here
                // For now, we'll just close the connection and print a message
                socket.close();
                System.out.println("Connection closed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}