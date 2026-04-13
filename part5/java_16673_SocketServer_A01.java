import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16673_SocketServer_A01 {
    private static final int PORT = 6666;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Here you can write code to handle the client connection and process the request
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}