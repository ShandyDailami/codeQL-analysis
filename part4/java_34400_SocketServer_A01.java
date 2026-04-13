import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34400_SocketServer_A01 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");

                new Thread(() -> {
                    try {
                        // Receive a message from client
                        byte[] buffer = new byte[1024];
                        socket.getInputStream().read(buffer);
                        String message = new String(buffer);
                        System.out.println("Received: " + message);

                        // Send a message back to client
                        String response = "Hello, client";
                        socket.getOutputStream().write(response.getBytes());

                        socket.close();
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