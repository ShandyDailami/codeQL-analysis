import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41148_SocketServer_A03 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected!");

                new Thread(() -> {
                    try {
                        byte[] buffer = new byte[1024];
                        int bytesRead = socket.getInputStream().read(buffer);

                        if (bytesRead < 0) {
                            System.out.println("Client disconnected!");
                            return;
                        }

                        String message = new String(buffer, 0, bytesRead);
                        System.out.println("Received message from client: " + message);

                        // TODO: Implement security-sensitive operations related to A03_Injection here

                        String response = "Server response: " + message;
                        socket.getOutputStream().write(response.getBytes());
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