import java.net.ServerSocket;
import java.net.Socket;

public class java_11850_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT + "...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Perform security sensitive operations here
                // For example, validate the username and password
                String username = socket.getRemoteSocketAddress().toString();
                if (!username.equals("localhost")) {
                    System.out.println("Invalid username: " + username);
                    socket.close();
                    continue;
                }

                // Receive data from the client
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String receivedData = new String(buffer);

                // Perform other security sensitive operations here
                // For example, validate the received data
                if (!receivedData.equals("Hello, World!")) {
                    System.out.println("Invalid data: " + receivedData);
                    socket.close();
                    continue;
                }

                // Send response back to the client
                String response = "Hello, Client!";
                socket.getOutputStream().write(response.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}