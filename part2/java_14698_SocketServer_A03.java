import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14698_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Handle the client connection here
                // For simplicity, we'll just broadcast the message
                new Thread(() -> {
                    try {
                        String message = "Hello client, you are connected to the server!";
                        socket.getOutputStream().write(message.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}