import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18998_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 9876;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Here you would typically create a new thread to handle each connection
                // but since this is a simple example, we'll just print a message and close the connection
                System.out.println("Received a message from client");
                socket.close();
           
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}