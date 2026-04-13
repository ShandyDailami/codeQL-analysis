import java.net.ServerSocket;
import java.net.Socket;

public class java_28625_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Secure connection
                socket.setSoTimeout(10000);

                // Receive message from client
                byte[] bytes = new byte[1024];
                socket.getInputStream().read(bytes);
                String message = new String(bytes);

                // Send response back to client
                String response = "Hello, client!";
                socket.getOutputStream().write(response.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}