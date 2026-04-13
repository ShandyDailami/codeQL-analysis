import java.net.ServerSocket;
import java.net.Socket;

public class java_38504_SocketServer_A03 {
    private static final int PORT = 6000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected");

                // Here we would normally handle the communication with the client
                // But since we're not using external libraries, this is a bit abstract
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}