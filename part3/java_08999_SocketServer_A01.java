import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08999_SocketServer_A01 {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected");

                // Here you should implement a secure way to handle the client
                // For now, we are just accepting the connection and closing it
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}